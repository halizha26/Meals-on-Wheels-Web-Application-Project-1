package com.group6.MoM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group6.MoM.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository ur;
	
	
	public ResponseEntity<String> setApproveal(int userId, boolean status) {
	    try {
	        ur.updateApprovedStatus(userId, status);
	        return ResponseEntity.ok("Approval status updated successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating approval status");
	    }
	}
	
	
	
	
}
