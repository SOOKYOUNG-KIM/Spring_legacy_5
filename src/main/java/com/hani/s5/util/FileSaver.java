package com.hani.s5.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	//전체적인 순서
	//1. 폴더 생성
	//2. 저장할 파일명 생성
	//3. 파일을 HDD에 저장
	
	
	
	//1. FileCopyUtils 클래스 사용
	public String saveByUtils(MultipartFile file, String path)throws Exception{
		//1. path의 경로에 폴더가 있는지 없는지부터 확인.
		File f = new File(path);
		if(!f.exists()) {
			//resources/memberUpload
			//resources/upload/member
			f.mkdirs();
		}
		
		//a. 저장할 파일명 생성
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		
		f = new File(f, fileName);
		//b. 데이터를 HDD에 저장
		FileCopyUtils.copy(file.getBytes(), f);
		return fileName;
	}
	
	//2. MutipartFile 자체 메서드
	public String saveByTransfer(MultipartFile file, String path)throws Exception{
		//1. path의 경로에 폴더가 있는지 없는지부터 확인.
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		
		f = new File(f, fileName);
		file.transferTo(f);
			
		return fileName;
	}
	
	//3. OutputStream
	public String saveByStream(MultipartFile file, String path)throws Exception {
		//1. path의 경로에 폴더가 있는지 없는지부터 확인.
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
			
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
			
		f = new File(f, fileName);
		
		FileOutputStream fs = new FileOutputStream(f);
		fs.write(file.getBytes());
		fs.close();
		
		return fileName;
	}
	
	
	
	private String makeNameByUUID(String name) {
		String result = UUID.randomUUID().toString();
		result = result+"_"+name;

		return result;
	}
	
	private String makeNameByTime(String name) {
		Calendar ca = Calendar.getInstance();	//추상메서드의 객체 가져오는 것
		Long l = ca.getTimeInMillis();
		
		String result = name.substring(0, name.indexOf("."));
		result = result+"_"+l;
		result = result+name.substring(name.lastIndexOf("."));

		
		return result;
	}
	
	
	//File Delete
	public int deleteFile(String fileName, String path)throws Exception{
		File file = new File(path, fileName);
		boolean check = false;
		int result = 0;
		if(file.exists()) {
			check = file.delete();
		}
		
		if(check) {
			result = 1;
		}
		return result;
	}
	

}
