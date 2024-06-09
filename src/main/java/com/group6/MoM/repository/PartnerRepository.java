package com.group6.MoM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.MoM.entity.Member;
import com.group6.MoM.entity.Partner;
import com.group6.MoM.entity.User;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
	
	public Partner findByUser(User user);

	public Partner findByPartnerId(int id);
}
