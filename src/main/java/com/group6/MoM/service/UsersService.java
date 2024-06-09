package com.group6.MoM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.group6.MoM.entity.User;
import com.group6.MoM.model.Donatur;
import com.group6.MoM.model.Driver;
import com.group6.MoM.model.Member;
import com.group6.MoM.model.Partner;
import com.group6.MoM.model.Volunteer;
import com.group6.MoM.repository.DonaturRepository;
import com.group6.MoM.repository.DriverRepository;
import com.group6.MoM.repository.MemberRepository;
import com.group6.MoM.repository.PartnerRepository;
import com.group6.MoM.repository.RoleRepository;
import com.group6.MoM.repository.UserRepository;
import com.group6.MoM.repository.VolunteerRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private MemberRepository mr;
	
	@Autowired
	private VolunteerRepository vr;
	
	@Autowired
	private DonaturRepository dr;
	
	@Autowired
	private PartnerRepository pr;
	
	@Autowired
	private DriverRepository dvr;
	
	@Autowired
	private RoleRepository rr;
	
	@Autowired
	private PasswordEncoder pwe;
	
	
	public boolean registerMember( Member member) {
		try {
			String encodePaswword = pwe.encode(member.getPassword());
			User savedUser = new User();
			
			savedUser.setEmail(member.getEmail());
			savedUser.setUsername(member.getUsername());
			savedUser.setPassword(encodePaswword);
			savedUser.setRole(rr.findBySpecificRole("member"));
			savedUser.setApproved(false);
			ur.save(savedUser);
			
			com.group6.MoM.entity.Member savedMember = new com.group6.MoM.entity.Member();
			
			savedMember.setUser(savedUser);
			savedMember.setName(member.getName());
			savedMember.setPhone(member.getPhone());
			savedMember.setAddress(member.getAddress());
			mr.save(savedMember);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean registerVolunteer(Volunteer volunteer) {
	    try {
	        String encodePassword = pwe.encode(volunteer.getPassword());
	        User savedUser = new User();
	        savedUser.setEmail(volunteer.getEmail());
	        savedUser.setUsername(volunteer.getUsername());
	        savedUser.setPassword(encodePassword);
	        savedUser.setRole(rr.findBySpecificRole("volunteer"));
			savedUser.setApproved(false);
	        ur.save(savedUser);

	        com.group6.MoM.entity.Volunteer savedVolunteer = new com.group6.MoM.entity.Volunteer();
	        savedVolunteer.setUser(savedUser);
	        savedVolunteer.setName(volunteer.getName());
	        savedVolunteer.setPhone(volunteer.getPhone());
	        savedVolunteer.setAddress(volunteer.getAddress());
	        vr.save(savedVolunteer);

	        return true; 
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public boolean registerDonatur(Donatur donatur) {
	    try {
	        String encodePassword = pwe.encode(donatur.getPassword());
	        User savedUser = new User();
	        savedUser.setEmail(donatur.getEmail());
	        savedUser.setUsername(donatur.getUsername());
	        savedUser.setPassword(encodePassword);
	        savedUser.setRole(rr.findBySpecificRole("donatur"));
			savedUser.setApproved(false);
	        ur.save(savedUser);

	        com.group6.MoM.entity.Donatur savedDonatur = new com.group6.MoM.entity.Donatur();
	        savedDonatur.setUser(savedUser);
	        savedDonatur.setName(donatur.getName());
	        savedDonatur.setPhone(donatur.getPhone());
	        savedDonatur.setAmount(donatur.getAmount());
	        dr.save(savedDonatur);

	        return true; // Operasi berhasil
	    } catch (Exception e) {
	        return false; // Operasi gagal
	    }
	}
	
	public boolean registerPartner(Partner partner) {
	    try {
	        String encodePassword = pwe.encode(partner.getPassword());
	        User savedUser = new User();
	        savedUser.setEmail(partner.getEmail());
	        savedUser.setUsername(partner.getUsername());
	        savedUser.setPassword(encodePassword);
	        savedUser.setRole(rr.findBySpecificRole("partner"));
			savedUser.setApproved(false);
	        ur.save(savedUser);

	        com.group6.MoM.entity.Partner savedPartner = new com.group6.MoM.entity.Partner();
	        savedPartner.setUser(savedUser);
	        savedPartner.setName(partner.getName());
	        savedPartner.setAddress(partner.getAddress());
	        savedPartner.setBrand(partner.getBrand());
	        savedPartner.setPhone(partner.getPhone());
	        pr.save(savedPartner);

	        return true; // Operasi berhasil
	    } catch (Exception e) {
	        return false; // Operasi gagal
	    }
	}
	
	public boolean registerDriver(Driver driver) {
	    try {
	        String encodePassword = pwe.encode(driver.getPassword());
	        User savedUser = new User();
	        savedUser.setEmail(driver.getEmail());
	        savedUser.setUsername(driver.getUsername());
	        savedUser.setPassword(encodePassword);
	        savedUser.setRole(rr.findBySpecificRole("driver"));
			savedUser.setApproved(false);
	        ur.save(savedUser);

	        com.group6.MoM.entity.Driver savedDriver = new com.group6.MoM.entity.Driver();
	        savedDriver.setUser(savedUser);
	        savedDriver.setName(driver.getName());
	        savedDriver.setAddress(driver.getAddress());
	        savedDriver.setPhone(driver.getPhone());
	        dvr.save(savedDriver);

	        return true; // Operasi berhasil
	    } catch (Exception e) {
	        return false; // Operasi gagal
	    }
	}
	
//	public List<User> listAllUser(){
//		List<User> userList = ur.findAllUsers();
//		return userList;
//
//	}

}
