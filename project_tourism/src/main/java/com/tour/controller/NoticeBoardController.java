package com.tour.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tour.common.Pagination;
import com.tour.dto.NoticeBoardDTO;
import com.tour.service.NoticeBoardService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeBoardController {
	private static final Logger log = LoggerFactory.getLogger(NoticeBoardController.class);
	@Autowired
	NoticeBoardService nbs;
	@RequestMapping(value = "/noticeList")
	public ModelAndView getList(Model model,@RequestParam(defaultValue = "notice_title") String searchOption,
									@RequestParam(defaultValue = "") String keyword,
									@RequestParam(defaultValue = "1") int curPage) throws Exception
									{
		// 게시물의 총 개수 계산
		int count = nbs.countBoardList(searchOption, keyword);
		
		// 페이지 나누기 관련 처리
		Pagination pagination = new Pagination(count, curPage);
		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		List<NoticeBoardDTO> list = nbs.getList(start, end, searchOption, keyword);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // list
		map.put("count", count); //게시물 개수
		map.put("searchOption", searchOption); //검색 옵션
		map.put("keyword", keyword); //검색 키워드
		map.put("pagination", pagination);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("notice/noticeList");
		return mav;
	}
	
	@GetMapping(value = "/regForm")
	public String regFrom() {
		return "notice/regForm";
	}
	@PostMapping(value = "/regBoard")
	public String regBoard(HttpServletRequest req) {
		nbs.regBoard(req);
		return "redirect:noticeList";
	}
	@GetMapping(value = "/getDetail")
	public String getDetail(HttpServletResponse response,HttpServletRequest request,@RequestParam("no")String no,Model model) {
		
		Cookie[] cookies = request.getCookies();
		
		Cookie viewCookie = null;
		
		if (cookies != null && cookies.length > 0) {
			for (int i = 0 ; i < cookies.length;i++) {
				//Cookie의 name이 cookie + no와 일치하는 쿠키를 viewCookie에 넣어준다.
				if (cookies[i].getName().equals("cookie"+no)) {
					//처음 쿠키가 생성되고 들어온다.
					viewCookie = cookies[i];
				}
			}
		}
		
		//ViewCookie가 만약 null일 경우 쿠키를 생성해서 조회수 증가 로직 처리
		if (viewCookie == null) {
			Cookie newCookie = new Cookie("cookie"+no,no);
			//기본값으로 브라우저가 꺼졌을 때 쿠키 삭제
			response.addCookie(newCookie);
			nbs.upHit(no);
		} 
		
		model.addAttribute("contentView", nbs.getDetail(no));
		return "notice/contentView";
	}
	
	@GetMapping(value = "/modifyForm")
	public String getModifyForm(@RequestParam("no") String no, Model model) {
		model.addAttribute("contentView", nbs.getDetail(no));
		return "notice/modifyForm";
	}
	@PostMapping(value = "/modifyOk")
	public String modifyOk(NoticeBoardDTO dto) {
		nbs.modifyOk(dto);
		return "redirect:noticeList";
	}
	@GetMapping(value = "/delete")
	public String deleteBoard(@RequestParam("no") String no) {
		nbs.deleteBoard(no);
		return "redirect:noticeList";
	}
	@PostMapping(value = "/imageUpload")
	public void imageUpload(HttpServletRequest request,HttpServletResponse response, MultipartHttpServletRequest mul
							, @RequestParam MultipartFile upload) throws Exception{
		//랜덤 문자 생성?
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		//인코딩
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		try {
			//파일 이름 가져오기
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			//이미지 경로 생성
			String path = "c:\\noticeImage/";
			String ckUploadPath = path + uid + "_" + fileName;
			File folder = new File(path);
			
			//해당 디렉토리 확인
			if(!folder.exists()) {
				try {
					folder.mkdir(); //폴더 생성
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush(); //outputSteam에 저장된 데이터 전송 후 초기화
			
			String callback = request.getParameter("notice_content");
			printWriter = response.getWriter();
			String fileUrl = "ckImageSubmit?uid="+uid+"&fileName="+fileName; //작성화면
			
			//업로드시 메세지 출력
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
	        printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) {out.close();}
				if(printWriter != null) {printWriter.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return;
	}
	
	@GetMapping(value = "ckImageSubmit") 
	public void ckImageSubmit(@RequestParam(value="uid") String uid,
							@RequestParam(value="fileName") String fileName,
							HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException{
		//서버에 저장된 이미지 경로
		String path = "c:\\noticeImage/";
		String sDirPath = path + uid + "_" + fileName;
		
		File imageFile = new File(sDirPath);
		
		//사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일 생성
		
		if (imageFile.isFile()) {
			byte[] buf = new byte[1024];
			int readByte = 0;
			int length = 0;
			byte[] imgBuf = null;
			
			FileInputStream fileInputStream = null;
			ByteArrayOutputStream outputStream = null;
			ServletOutputStream out = null;
			
			try {
				fileInputStream = new FileInputStream(imageFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();
                
                while((readByte = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0, readByte);
                }
                
                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				outputStream.close();
				fileInputStream.close();
				out.close();
			}
		}
	}
}
