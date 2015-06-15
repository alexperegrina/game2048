package fib.as.game2048;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CtrlJugador {
	
	public Jugador getJugador(String userN)
	{
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Jugador j = (Jugador)session.load(Jugador.class, userN);
		
		session.close();
		
		return j;
	}
	
	public ArrayList<Jugador> getAllJugadors()
	{
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
		jugadors.addAll(session.createCriteria(Jugador.class).list());
		
		session.close();
		return jugadors;
		
	}
	
}
