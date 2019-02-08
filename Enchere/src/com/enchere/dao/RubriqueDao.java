package com.enchere.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.enchere.entities.Rubrique;


public class RubriqueDao {
	
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
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tnx = session.beginTransaction();
	Query query =session.createQuery("FROM Rubrique");
	 listRubrique = query.list();
	tnx.commit();
	session.close();
	return listRubrique;
	}

}

