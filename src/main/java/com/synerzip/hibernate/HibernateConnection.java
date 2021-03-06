package com.synerzip.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.synerzip.model.Project;

public class HibernateConnection {
	public static Session getSession() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Project.class);
		SessionFactory sf = con.buildSessionFactory();
		return sf.openSession();
	}
}
