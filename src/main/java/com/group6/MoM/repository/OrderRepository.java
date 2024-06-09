package com.group6.MoM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.MoM.entity.OrderMenu;

@Repository
public interface OrderRepository extends JpaRepository<OrderMenu, Integer>{

}
