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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
//	https://ckeditor.com/docs/ckeditor4/latest/guide/dev_file_upload.html
	@PostMapping(value="/fileUpload")
	public void imageUpload(HttpServletRequest request,HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception{
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
			
			printWriter = response.getWriter();
			String fileUrl = "/ckImageSubmit?uid="+uid+"&fileName="+fileName; //작성화면
			
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
	
	@GetMapping(value = "/ckImageSubmit") 
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
