package fib.as.game2048;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = initSessionFactory();
		
		Partida p1 = new Partida(1);
		PrimaryKeyCasella key1 = new PrimaryKeyCasella(1, 1, p1);
		Casella c1 = new Casella(key1, 2);
		List<Casella> caselles = new ArrayList<Casella>();
		caselles.add(c1);
		p1.setCaselles(caselles);
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(p1);
		
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();

	}
	
	public static SessionFactory initSessionFactory() {
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		//se va a leer el fichero de configuración hibernate.cfg.xml.
		configuration.configure();
		//contiene la lista de los distintos servicios que usará hibernate
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}

}
