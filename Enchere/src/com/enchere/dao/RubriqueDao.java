package com.enchere.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.Rubrique;
import com.enchere.entities.Utilisateur;


public class RubriqueDao {
	public static SessionFactory sessionFactory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

public static void insertRubrqiue(Rubrique newRubrique,int idMaster) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		session.saveOrUpdate(newRubrique);
		if (idMaster!=-1)
		{
		Query updatedEntities = session.createQuery( "update Rubrique set MASTERRUBRIQUE_ID = :master where NOMRUBRIQUE = :nomRubrique");
		updatedEntities.setParameter("master", idMaster);
		updatedEntities.setParameter("nomRubrique", newRubrique.getNomRubrique());
		int result = updatedEntities.executeUpdate();   
		}
		tnx.commit();
		session.close();
		}



public static List getRubriques() {
	List<Rubrique> listRubrique= new ArrayList<Rubrique>();
	if(sessionFactory==null)
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query query =session.createQuery("FROM Rubrique");
	 listRubrique = query.list();
	tnx.commit();
	session.close();
	return listRubrique;
	}
	
	public static Rubrique getRubriqueById(int idRubrique) {
		if(sessionFactory==null)
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tnx = session.beginTransaction();
			List<Rubrique> listU = new ArrayList<Rubrique>();
			Query query = session.createQuery("From Rubrique where idRubrique = '"+idRubrique+"'");
			listU = query.list();
			tnx.commit();
			session.close();
			return listU.get(0);
	}

}

