package com.nt.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Customer;
import com.nt.domain.Vendor;

public class Test {
	public static void main(String[] args) {
		SessionFactory ses=new Configuration().configure("com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session s=ses.openSession();
		Customer c=new Customer();
		c.setCname("Uma");
		Customer c1=new Customer();
		c1.setCname("Uma");
		Vendor v=new Vendor();
		v.setVname("IKEA");
		Set<Customer> s1=new HashSet<>();
		s1.add(c);
		s1.add(c1);
		v.setCustomer(s1);
		Transaction tx=s.beginTransaction();
		System.out.println("Data is stored");
		s.save(v);
		tx.commit();
	}

}
