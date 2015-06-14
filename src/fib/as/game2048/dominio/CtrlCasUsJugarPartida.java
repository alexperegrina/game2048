package fib.as.game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CtrlCasUsJugarPartida {
	
	private Partida P;
	
	private ArrayList<Casella> caselles;
	
	public void crearPartida(Jugador jugador)
	{
		Joc2048 joc = new Joc2048();
		Integer id = joc.getIdPartida();
		Integer id1 = joc.incrementarId();
		P = new Partida(jugador,id);
		caselles = P.getCaselles();
		EstrategiaPuntuacio E;
		joc.assignarEstrategia(E);
		jugador.assignarPartidaActual(P);
		Integer points = jugador.getMillorPuntuacio();
		//No entiendo nada
	}
	
	public class ordenaporfila implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella1.getNumeroFila().compareTo(new Integer(casella2.getNumeroFila())));
		}
	}
	
	public class ordenaporfilainversa implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella2.getNumeroFila().compareTo(new Integer(casella1.getNumeroFila())));
		}
	}
	
	public class ordenaporcolumna implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella1.getNumeroColumna().compareTo(new Integer(casella2.getNumeroColumna())));
		}
	}
	
	public class ordenaporcolumnainversa implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella2.getNumeroColumna().compareTo(new Integer(casella1.getNumeroColumna())));
		}
	}
	
	public ArrayList obteFila(boolean ordre, Integer fila)
	{
		ArrayList<Casella>filaCaselles = new ArrayList<Casella>();
		Integer i = 0;
		while(i<caselles.size())
		{
			Integer n = caselles.get(i).getNumeroFila();
			if(n == fila) filaCaselles.add(caselles.get(i));
			++i;
		}
		Collections.sort(filaCaselles, new ordenaporfila());
		if(ordre == true) Collections.sort(filaCaselles, new ordenaporfilainversa());
		return filaCaselles;
	}
	
	public ArrayList obteCol(boolean ordre, Integer col)
	{
		ArrayList<Casella> colCaselles = new ArrayList<Casella>();
		Integer i = 0;
		while(i<caselles.size())
		{
			Integer n = caselles.get(i).getNumeroColumna();
			if(n == col) colCaselles.add(caselles.get(i));
			++i;
		}
		Collections.sort(colCaselles, new ordenaporcolumna());
		if(ordre == true) Collections.sort(colCaselles, new ordenaporcolumnainversa());
		return colCaselles;
	}
	
}