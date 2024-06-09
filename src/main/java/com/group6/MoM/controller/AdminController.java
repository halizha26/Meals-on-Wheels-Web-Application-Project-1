package com.group6.MoM.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group6.MoM.dto.RegisterDto;
import com.group6.MoM.entity.Donatur;
import com.group6.MoM.entity.Driver;
import com.group6.MoM.entity.Member;
import com.group6.MoM.entity.Partner;
import com.group6.MoM.entity.User;
import com.group6.MoM.entity.Volunteer;
import com.group6.MoM.repository.DonaturRepository;
import com.group6.MoM.repository.DriverRepository;
import com.group6.MoM.repository.MemberRepository;
import com.group6.MoM.repository.PartnerRepository;
import com.group6.MoM.repository.UserRepository;
import com.group6.MoM.repository.VolunteerRepository;
import com.group6.MoM.service.AdminService;
import com.group6.MoM.service.UsersService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private UsersService us;
	
	@Autowired
	private AdminService as;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	MemberRepository mr;
	
	@Autowired
	VolunteerRepository vr;
	
	@Autowired
	DonaturRepository dr;
	
	@Autowired
	DriverRepository dvr;
	
	@Autowired
	PartnerRepository pr;
	
	@GetMapping("/all_user")
	public List<RegisterDto> allUser(){
		List<User> users = ur.findAll();
		
		List<RegisterDto> userData = new ArrayList<RegisterDto>();;
		for (User user : users) {
			
			
			if(user.getRole().getName().equals("member")) {
				Member roleData = mr.findByUser(user);
				userData.add(new RegisterDto(user, roleData ));
			}else if(user.getRole().getName().equals("volunteer")) {
				Volunteer roleData = vr.findByUser(user);
				userData.add(new RegisterDto(user, roleData ));
			}else if(user.getRole().getName().equals("donatur")) {
				Donatur roleData = dr.findByUser(user);
				userData.add(new RegisterDto(user, roleData )); 
			}else if(user.getRole().getName().equals("driver")) {
				Driver roleData = dvr.findByUser(user);
				userData.add(new RegisterDto(user, roleData ));
			}else if(user.getRole().getName().equals("partner")) {
				Partner roleData = pr.findByUser(user);
				userData.add(new RegisterDto(user, roleData ));
			}
		}
		return userData;
	}
	
	@PostMapping("/approve/{id}")
	public String approveUser(@PathVariable("id") int id) {
		as.setApproveal(id, true);
		return "ok";
	}
	
	
}
