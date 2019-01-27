package com.enchere.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.Article;
import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ArticleEnchereHollandaise;

public class ArticleDao {
	
public static void insertArticleEnchereAnglaise(ArticleEnchereAnglaise newArticleEnchereAnglaise) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(newArticleEnchereAnglaise);
		tnx.commit();
		session.close();
		}

public static void insertArticleEnchereHollandaise(ArticleEnchereHollandaise newArticleEnchereHollandaise) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	session.save(newArticleEnchereHollandaise);
	tnx.commit();
	session.close();
	}
}
