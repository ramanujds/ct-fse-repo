package com.ct.springboot.imageupload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

	final String uploadDir="src/main/resources/static/images";
	
	@PostMapping("/upload")
	public String uploadImage(@RequestParam("image") MultipartFile file) {
		if(file==null) {
			throw new RuntimeException("No file Specified");
		}
		
		String fileName=file.getOriginalFilename();
		
		Path path=Paths.get(uploadDir);
		
		if(!Files.exists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			
			InputStream inputStream=file.getInputStream();
			Path finalPath=path.resolve(fileName);
			Files.copy(inputStream, finalPath, StandardCopyOption.REPLACE_EXISTING);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		
		return "success.jsp";
	}
	
	@GetMapping("/image")
	public String getImage(Model m) {
		m.addAttribute("imageloc","images/human.png");
		return "show-image.jsp";
	}
	
	
}
