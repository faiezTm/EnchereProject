package com.enchere.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ConfigurationSite;
import com.enchere.entities.Rubrique;

public class ConfigDao {
	
public static void insertConfig(ConfigurationSite configurationSite) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(configurationSite);
		tnx.commit();
		session.close();
		}
public static List getConfig() {
	List<ConfigurationSite> listConfig= new ArrayList<ConfigurationSite>();
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query query =session.createQuery("FROM ConfigurationSite");
	listConfig = query.list();
	tnx.commit();
	session.close();
	return listConfig;
	}



}
