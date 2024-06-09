package com.group6.MoM.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group6.MoM.entity.Partner;
import com.group6.MoM.entity.Picture;
import com.group6.MoM.model.Menus;
import com.group6.MoM.repository.MenusRepository;
import com.group6.MoM.repository.PartnerRepository;
import com.group6.MoM.service.PartnerService;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {

	@Autowired
	private MenusRepository menuRepo;
	
	@Autowired
	private PartnerRepository pr;
	
	@Autowired
	private PartnerService ps;

	
	@PostMapping("/post_menu")
	public String saveMenu(Menus menuModel,@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		
		Picture pict = ps.uploadImage(multipartFile);
		com.group6.MoM.entity.Menus menu = new com.group6.MoM.entity.Menus();
		Partner partner = pr.findByPartnerId(menuModel.getPartnerId());
		menu.setName(menuModel.getName());
		menu.setCarb(menuModel.getCarb());
		menu.setFat(menuModel.getFat());
		menu.setProtein(menuModel.getProtein());
		menu.setPartner(partner);
		menu.setPicture(pict);
		menuRepo.save(menu);
		
		return "ok";
	}
	
	@GetMapping("/list_menu")
	public List<com.group6.MoM.entity.Menus> allMenu(){
		return menuRepo.findAll();
	}
	
	
}
