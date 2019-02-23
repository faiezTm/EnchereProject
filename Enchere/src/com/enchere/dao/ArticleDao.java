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

public static void editArticleEnchereAnglaise(ArticleEnchereAnglaise newArticleEnchereAnglaise, int idArticle) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	newArticleEnchereAnglaise.setIdArticle(idArticle);
	session.update(newArticleEnchereAnglaise);
	tnx.commit();
	session.close();
	
}

public static void deleteArticleEnchereAnglaise(int idArticle) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	ArticleEnchereAnglaise deletedArticle = new ArticleEnchereAnglaise();
	deletedArticle.setIdArticle(idArticle);
	session.delete(deletedArticle);
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

public static void editArticleEnchereHollandaise(ArticleEnchereHollandaise newArticleEnchereHollandaise, int idArticle) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	newArticleEnchereHollandaise.setIdArticle(idArticle);
	session.update(newArticleEnchereHollandaise);
	tnx.commit();
	session.close();
	
}

public static void deleteArticleEnchereHollandaise(int idArticle) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	ArticleEnchereHollandaise deletedArticle = new ArticleEnchereHollandaise();
	deletedArticle.setIdArticle(idArticle);
	session.delete(deletedArticle);
	tnx.commit();
	session.close();
	
}

public static List<ArticleEnchereAnglaise> getAllArticlesEnchereAnglaiseByUser(int idUtilisateur){
	try {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		Query queryArticleEnchereAnglaise = session.createQuery("From ArticleEnchereAnglaise where UTILISATEUR_IDUTILISATEUR = '"+idUtilisateur+"'");
		List<ArticleEnchereAnglaise> listArticleEnchereAnglaise = queryArticleEnchereAnglaise.list();
		return listArticleEnchereAnglaise;
	}
	catch (Exception e) {
		return null;
	}
}

public static List<ArticleEnchereHollandaise> getAllArticlesEnchereHollandaiseByUser(int idUtilisateur){
	try {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query queryArticleEnchereHollandaise = session.createQuery("From ArticleEnchereHollandaise where UTILISATEUR_IDUTILISATEUR = '"+idUtilisateur+"'");
	List<ArticleEnchereHollandaise> listArticleEnchereHollandaise = queryArticleEnchereHollandaise.list();
	return listArticleEnchereHollandaise;
}
catch (Exception e) {
	return null;
}
}

public static List<ArticleEnchereHollandaise> getAllArticlesEnchereHollandaiseTrieParDate(){
	try {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query queryArticleEnchereHollandaise = session.createQuery("From ArticleEnchereHollandaise order by dateFin desc");
	List<ArticleEnchereHollandaise> listArticleEnchereHollandaise = queryArticleEnchereHollandaise.list();
	return listArticleEnchereHollandaise;
}
catch (Exception e) {
	return null;
}
}	
}