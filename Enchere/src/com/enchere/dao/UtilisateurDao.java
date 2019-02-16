package com.enchere.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.Membre;
import com.enchere.entities.Rubrique;
import com.enchere.entities.Utilisateur;





public class UtilisateurDao {
public static void insertMembre(Membre membre) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(membre);
		tnx.commit();
		session.close();
		}
public static Utilisateur authentification(String login,String motDePasse) {
	List<Utilisateur> listU = new ArrayList<Utilisateur>();
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	String hql = "FROM Utilisateur";
	Query query = session.createQuery(hql);
	listU = query.list();
	for (Utilisateur u : listU) {
		if (u.getLogin().equals(login) && u.getMotDePasse().equals(motDePasse)) {
			return u;
		}
	}
	Utilisateur uNull=null;
	tnx.commit();
	session.close();
	return uNull;
	}


}
