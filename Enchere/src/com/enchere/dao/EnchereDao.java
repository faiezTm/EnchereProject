package com.enchere.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.ArticleEnchereHollandaise;
import com.enchere.entities.Encherir;
import com.enchere.entities.Rubrique;
import com.enchere.entities.Utilisateur;

public class EnchereDao {
	public static void insertEnchere(Encherir ench) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(ench);
		tnx.commit();
		session.close();
		
	}
	
public static Encherir insertRubrqiue(Utilisateur u,ArticleEnchereHollandaise a) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		List <Encherir> listEnch=new ArrayList<>();
		Query updatedEntities = session.createQuery("FROM Encherir ");
		/*updatedEntities.setParameter("idArt", a.getIdArticle());
		updatedEntities.setParameter("idMembre", u.getIdUtilisateur());*/
		listEnch =updatedEntities.list();
		//Encherir E=(Encherir) updatedEntities.uniqueResult();   
		
		tnx.commit();
		session.close();
		return listEnch.get(listEnch.size()-1);
		}
}
