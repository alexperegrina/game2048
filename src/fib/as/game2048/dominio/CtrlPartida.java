package fib.as.game2048.dominio;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.service.ServiceRegistry;

public class CtrlPartida {
	
	public ArrayList<Partida> getAllPartidaJugada()
	{
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		partidas.addAll(session.createCriteria(Partida.class).addOrder(Order.asc("idPartida")).list());
		
		session.close();
		return partidas;
		
	}
}