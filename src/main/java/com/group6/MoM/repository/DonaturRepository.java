package com.group6.MoM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.MoM.entity.Donatur;
import com.group6.MoM.entity.Member;
import com.group6.MoM.entity.User;

@Repository
public interface DonaturRepository extends JpaRepository<Donatur, Integer> {
	
	public Donatur findByUser(User user);

}
