package com.enchere.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ConfigurationSite;

public class ConfigDao {
	
public static void insertConfig(ConfigurationSite configurationSite) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(configurationSite);
		tnx.commit();
		session.close();
		}

}
