package com.group6.MoM.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Donatur {

	/*for user table*/
	private String name;
	
	private String username;
	
	private String email;
	
	/*for donatur table*/
	
	private String phone;
	
	private String password;
	
	private int amount;
	
}
