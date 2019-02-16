package com.enchere.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;

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

public static List<ArticleEnchereAnglaise> getAllArticlesEnchereAnglaise(){
	try {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		Query queryArticleEnchereAnglaise = session.createQuery("From ArticleEnchereAnglaise");
		List<ArticleEnchereAnglaise> listArticleEnchereAnglaise = queryArticleEnchereAnglaise.list();
		return listArticleEnchereAnglaise;
	}
	catch (Exception e) {
		return null;
	}
}

public static List<ArticleEnchereHollandaise> getAllArticlesEnchereHollandaise(){
	try {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query queryArticleEnchereHollandaise = session.createQuery("From ArticleEnchereHollandaise");
	List<ArticleEnchereHollandaise> listArticleEnchereHollandaise = queryArticleEnchereHollandaise.list();
	return listArticleEnchereHollandaise;
}
catch (Exception e) {
	return null;
}
}
}