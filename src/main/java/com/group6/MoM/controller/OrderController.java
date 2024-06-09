package com.group6.MoM.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group6.MoM.entity.OrderMenu;
import com.group6.MoM.repository.OrderRepository;
import com.group6.MoM.service.OrderMenuService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderMenuService oms;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@PostMapping("/new_order")
	public void newOrder(@RequestBody Map<String, Object> requestData) {
	    int menuId = (int) requestData.get("menuId");
	    int memberId = (int) requestData.get("memberId");
	    
	    oms.newOrder(menuId, memberId);
	}
	
	@GetMapping("/list_order")
	public List<OrderMenu> listOrder(){
		return orderRepo.findAll();
	}
	
	@PostMapping("/proses_order/{order_id}")
	public void prosesOrder(@PathVariable("order_id") int orderId) {
		oms.changeStatusOrder("proses", orderId);
	}
	
	@PostMapping("/ready_order/{order_id}")
	public void readyOrder(@PathVariable("order_id") int orderId) {
		oms.changeStatusOrder("ready to deliver", orderId);
	}
	
	@PostMapping("/delivered_order/{order_id}")
	public void deliveredOrder(@PathVariable("order_id") int orderId, @RequestBody Map<String, Integer> requestData) {
	    int driverId = requestData.get("driverId");
	    oms.deliveredOrder(orderId, driverId);
	}

	@PostMapping("/done_order/{order_id}")
	public void doneOrder(@PathVariable("order_id") int orderId) {
		oms.changeStatusOrder("Order has been received by member", orderId);
	}
	
}
 