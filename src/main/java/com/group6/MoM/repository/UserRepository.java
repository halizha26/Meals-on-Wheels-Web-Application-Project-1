package com.group6.MoM.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group6.MoM.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);

	public User findByUsername(String username);

	@Transactional
	@Modifying
    @Query("UPDATE User u SET u.approved = :approved WHERE u.userId = :userId")
    void updateApprovedStatus(int userId, boolean approved);
	
	
	
}
