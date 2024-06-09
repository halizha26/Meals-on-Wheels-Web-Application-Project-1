package com.group6.MoM.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
	private int partnerId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String name;
	
	private String address;
	
	private String phone;
		
	private String brand;
	
	@OneToMany(mappedBy = "partner")
	private Set<Menus> menus = new HashSet<Menus>();
}
