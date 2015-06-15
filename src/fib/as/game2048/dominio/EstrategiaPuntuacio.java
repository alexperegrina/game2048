package fib.as.game2048.dominio;

import java.util.ArrayList;

public class EstrategiaPuntuacio extends IEstrategiaRanking{
	
	public ArrayList<TuplePersPunt> getRanking(ArrayList<Jugador> jugadors)
	{
		Integer i = 0;
		ArrayList<TuplePersPunt> ranking = new ArrayList<TuplePersPunt>();
		while(i<jugadors.size())
		{
			TuplePersPunt tupla = new TuplePersPunt();
			tupla.setPunt(jugadors.get(i).getMillorPuntuacio());
			tupla.setNom(jugadors.get(i).getNom());
			if(ranking.isEmpty())ranking.add(tupla);
			else
			{
				Integer j = 0;
				boolean trobat = false;
				while(j<ranking.size() && !trobat)
				{
					if(tupla.getPunt() > ranking.get(j).getPunt())
						{
							ranking.add(j, tupla);
							trobat = true;
						}
					++j;
				}
				if(!trobat) ranking.add(tupla);
			}
			
			++i;
		}
		return ranking;
	}
}
