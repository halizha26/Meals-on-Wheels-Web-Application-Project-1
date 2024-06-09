package com.group6.MoM.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group6.MoM.entity.Picture;
import com.group6.MoM.repository.MenusRepository;
import com.group6.MoM.repository.PictureRepository;

@Service
public class PartnerService {

	@Autowired
	private MenusRepository menusRepo;
	
	@Autowired
	private PictureRepository pictRepo;
	
	public Picture uploadImage(MultipartFile file) {
		try {
			Picture pict = new Picture(); 
			
			pict.setFileName(file.getOriginalFilename());
			pict.setFileType(file.getContentType());
			pict.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			return pictRepo.save(pict);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
