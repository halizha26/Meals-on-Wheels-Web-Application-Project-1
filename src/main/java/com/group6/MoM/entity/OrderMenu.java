package com.group6.MoM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_menu")
public class OrderMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name = "menus_id")
	private Menus menu;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@Column(nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
}
