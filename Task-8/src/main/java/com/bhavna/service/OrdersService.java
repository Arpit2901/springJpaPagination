package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.bean.Orders;
import com.bhavna.dao.OrdersDao;

@Service
public class OrdersService {
	@Autowired
	OrdersDao orderDao;

	@Transactional
	public List getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Transactional
	public Orders getOrder(int id) {
		return orderDao.getOrder(id);
	}

	@Transactional
	public Orders placeOrder(Orders order) {
		return orderDao.placeOrder(order);
	}

	@Transactional
	public Orders updateOrder(Orders order) {
		return orderDao.placeOrder(order);
	}

	@Transactional
	public void deleteOrder(int id) {
		orderDao.deleteOrder(id);
	}
}
