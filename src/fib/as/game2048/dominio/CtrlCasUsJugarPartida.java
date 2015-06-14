package fib.as.game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CtrlCasUsJugarPartida {
	
	private Partida P;
	
	private ArrayList<Casella> caselles;
	
	public void crearPartida(Jugador jugador)
	{
		Joc2048 joc = new Joc2048();
		Integer id = joc.getIdPartida();
		Integer id1 = joc.incrementarId();
		P = new Partida(jugador,id);
		caselles = P.getCaselles(); P.
		EstrategiaPuntuacio E;
		joc.assignarEstrategia(E);
		jugador.assignarPartidaActual(P);
		Integer points = jugador.getMillorPuntuacio();
		//No entiendo nada
	}
	
	
	
	private static int randInt(int min, int max)
	{
		Random rand = new Random();
		int randomnum = rand.nextInt((max-min)+1)+min;
		return randomnum;
	}
	
	public ArrayList crearTaulell()
	{
		Integer i = 0;
		Integer j = 0;
		Integer c1 = randInt(0,15);
		Integer c2 = randInt(0,15);
		while(c1 == c2) c2 = randInt(0,15);
		Integer count = null;
		caselles = new ArrayList<Casella>();
		ArrayList<Casella> casellesValor = new ArrayList<Casella>();
		while(i<4)
		{
			j=0;
			count = 0;
			while(j<4)
			{
				Integer valor;
				if(count == c1 || count == c2)
				{
					valor = randInt(1,2)*2;
				}
				else valor = null;
				Casella C = new Casella(i,j,valor,P);
				//No entiendo como asignar partida dentro de partida
				caselles.add(C);
				if(count == c1 || count == c2) casellesValor.add(C);
				++j;
				++count;
			}
			++i;
		}
		return casellesValor;
		//No entiendo que es casellesValor.
		//Si es el valor, deduzco que deberiamos 
		//Guardar el valor, no la casilla
	}
	
	public void sumaPuntuacio(Integer punts)
	{
		this.puntuacio += punts;
	}
	
	public void potMoure(String mov)
	{
		ArrayList<Casella> linies = new ArrayList<Casella>();
		boolean potMoure = false;
		Integer i = 0, j = 0;
		while(i<4 && !potMoure)
		{
			boolean buidaFila = false;
			Integer numFila = null;
			//Tengo mis dudas de si es j = 4 y restar o j = 0 y sumar.
			while(j<4 && !potMoure)
			{
				if(linies.isEmpty()) buidaFila=true;
				if(buidaFila == true) potMoure = true;
				else
				{
				//	Integer n = linies.get(i/j).getNumero()
					if (n == numFila) potMoure=true;
					else numFila = n;
				}
			}
		}
	}
	
	public ArrayList obteLinies(String mov)
	{
		boolean ordre = true;
		ArrayList<Casella> linies = new ArrayList<Casella>();
		if(mov=="amunt" || mov=="esquerra") ordre = false;
		Integer i=0;
		while(i<4)
		{
			ArrayList<Casella> t = new ArrayList<Casella>();
			if(mov == "amunt" || mov == "avall") t = P.obteCol(ordre, i);
			if(mov == "dreta" || mov == "esquerra") t = P.obteFila(ordre, i);
			++i;
			linies.addAll(t);
		}
		return linies;
	}
	
	public ArrayList getCasellesValor()
	{
		ArrayList<Casella> conj = new ArrayList<Casella>();
		ArrayList<Casella> C = P.getCaselles();
		Integer i = 0;
		while(i<C.size())
		{
			if(!C.get(i).esBuida()) conj.add(C.get(i));
			++i;
		}
		return conj;
	}
	
	public boolean comprovarPartidaGuanyada()
	{
		boolean guanyada = false;
		Integer i = 0;
		while(i<caselles.size() && !guanyada)
		{
			if(caselles.get(i).getNumero()==2048) guanyada = true;
			++i;
		}
		return guanyada;
	}
	
}
