package com.bhavna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.bean.Orders;

@Repository
public class OrdersDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public List getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List countryList = session.createQuery("from Orders").list();
		return countryList;
	}

	public Orders getOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders order = (Orders) session.load(Orders.class, id);
		return order;
	}

	public Orders placeOrder(Orders order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(order);
		return order;
	}

	public void updateOrder(Orders order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(order);
	}

	public void deleteOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders order = (Orders) session.load(Orders.class, session);
		if (null != order) {
			session.delete(order);
		}

	}
}
