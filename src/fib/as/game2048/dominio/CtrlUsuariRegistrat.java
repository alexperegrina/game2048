package fib.as.game2048.dominio;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CtrlUsuariRegistrat {
	
	public UsuariRegistrat getUsuariRegistrat(String userN)
	{
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UsuariRegistrat u = (UsuariRegistrat)session.load(UsuariRegistrat.class, userN);
		
		session.close();
		
		return u;
	}
	
	public ArrayList<UsuariRegistrat> getAllUsuariRegistrat()
	{
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		ArrayList<UsuariRegistrat> u = new ArrayList<UsuariRegistrat>();
		u.addAll(session.createCriteria(UsuariRegistrat.class).list());
		
		session.close();
		return u;
		
	}
}
