package fib.as.game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		
		Integer count_random = 0;
		ArrayList<Integer> randCaselles = generateRandomsCaselles(4, 2);
		List<Casella> caselles = new ArrayList<Casella>();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int valor = 0;
				int numCasilla = ((j*4)+i)-1;
				if(randCaselles.contains(numCasilla)) {
					valor = randomInterval(1, 2)*2;
				}
				Casella c = new Casella(new PrimaryKeyCasella(i, j, p1), valor);
				caselles.add(c);
			}
		}
		
		
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

	/**
	 * Metodo que genera para una matriz cuadra casillas aleatorias diferentes entre ellas y con 
	 * una cierta cantidad.
	 * pre: cantidad < size*2
	 * @param sizeMat
	 * @param cuantitat cantidad de casillas a crear
	 * @return {@link ArrayList}
	 */
	public static ArrayList<Integer> generateRandomsCaselles(Integer sizeMat, Integer cuantitat) {
		Integer maxim = (sizeMat*2)-1;
		Integer minim = 0;
		ArrayList<Integer> caselles = new ArrayList<Integer>();
		
		int i = 0;
		while(i < cuantitat) {
			Integer randomNum = randomInterval(minim,maxim); 
			if(!caselles.contains(randomNum)) {
				caselles.add(randomNum);
				i++;
			}
		}
		
		return caselles;
	}
	
	/**
	 * Metodo que genera un numero random indicando un rango
	 * @param min
	 * @param max
	 * @return
	 */
	public static Integer randomInterval(Integer min, Integer max) {
		return (min + (int)(Math.random()*max));
	}
}
