package com.green.he.test;

import org.hibernate.Session;

import com.green.he.base.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session);
	}

}
