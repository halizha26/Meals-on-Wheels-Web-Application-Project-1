package com.group6.MoM.dto;

import com.group6.MoM.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

	private int userId;
    private String username;
    private String email;
    private String role;
    private boolean approved;
    private Object roleData;

    public RegisterDto(User user,  Object roleData) {
    	this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole().getName();
        this.approved = user.isApproved();
        this.roleData = roleData;
    }
}
