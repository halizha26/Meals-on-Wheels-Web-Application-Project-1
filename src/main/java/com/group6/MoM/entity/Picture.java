package com.group6.MoM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pictuer_id")
	private int pictureId;
	
	@Column(name= "file_name", nullable = false)
	private String fileName;
	
	@Column(name = "file_type", nullable = false)
	private String fileType;
	
	@Lob
	@Column(nullable = false)
	private String image;
	
	
}
