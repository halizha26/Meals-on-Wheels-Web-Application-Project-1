package com.group6.MoM.model;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Partner {

	
	private String username;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String phone;
	
	private String address;
	
	private String brand;

}
