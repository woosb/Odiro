package com.tour.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import com.tour.dto.BoardDTO;
import com.tour.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService service;
	
	@GetMapping(value="/list")
	public void list(Model model) {
		service.getList(model);
	}
	
	@GetMapping(value="/register")
	public void register() {}
	
	@PostMapping(value="/register")
	@ResponseBody
	public int register(BoardDTO dto) {
		int result = service.register(dto);
		log.info(dto.toString());
		return result;
	}
	
	@PostMapping(value="/fileUpload")
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
	
	@GetMapping(value="/detail")
	public String detail(@RequestParam("id") int id, Model model, HttpServletResponse response,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Cookie hitCookie = null;
		
		if(cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String cName = cookie.getName();
				String cValue = cookie.getValue();
				log.info(cookie.getName() + " : " + cookie.getValue());
				if(cName.equals("upHit") && cValue.equals("userId"+id)) {
					hitCookie = cookie;
					log.info("이미 존재하는 쿠키");
				}
			}
		}
		
		if(hitCookie == null) {
			service.upHit(id);
			hitCookie = new Cookie("upHit", "userId"+id);
			response.addCookie(hitCookie);
		}
		
		service.getDetail(model, id);
		return "/board/detail";
	}
	
	@GetMapping(value="recommend")
	public String upRecommend(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie recoCookie = null;
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				String cName = cookie.getName();
				String cValue = cookie.getValue();
				if(cName.equals("recommend") && cValue.equals("userId"+id)) {
					recoCookie = cookie;
					log.info("이미 존재하는 쿠키");
				}
			}
		}
		
		if(recoCookie == null) {
			recoCookie = new Cookie("recommend", "userId"+id);
			response.addCookie(recoCookie);
			service.upRecommend(id);
		}
		return "redirect:/board/detail?id="+id;
	}
	
	@GetMapping(value="/delete")
	public String delete(@Param("ref") int ref) {
		int result = service.delete(ref);
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/modify")
	public void modify(Model model, @Param("id") int id){
		service.getDetail(model, id);
	}
	
	@PostMapping(value="/modify")
	public String modify(BoardDTO dto) {
		log.info("dto : "+dto.toString());
		service.modify(dto);
		return "redirect:/board/list";
	}
	
	@PostMapping(value="/reply")
	public String reply(BoardDTO dto) {
		service.reply(dto);
		return "redirect:/board/detail?id="+dto.getId();
	}
}
