package com.group6.MoM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.MoM.entity.Admin;
import com.group6.MoM.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByUser(User user);
	

}
