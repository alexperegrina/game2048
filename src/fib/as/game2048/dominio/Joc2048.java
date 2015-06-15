package fib.as.game2048.dominio;

import java.util.ArrayList;

public final class Joc2048 {
	
	private static Integer idPartida;
	private static IEstrategiaRanking ranking;
	
	public static Integer getIdPartida() {
		return idPartida;
	}
	
	public static Integer incrementarId()
	{
		idPartida = idPartida+1;
		return idPartida;
	}
	
	public static void assignarEstrategia(IEstrategiaRanking E)
	{
		ranking = E;
	}
	
	public static ArrayList<TuplePersPunt> getRanking(ArrayList<Jugador> jugadors)
	{
		return ranking.getRanking(jugadors);
	}
	
	
	
}
