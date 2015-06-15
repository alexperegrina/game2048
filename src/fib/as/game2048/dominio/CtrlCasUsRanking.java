package fib.as.game2048;

import java.util.ArrayList;

public class CtrlCasUsRanking extends CtrlCasUs {

	public void consultarRanking()
	{
		CtrlPartida CP = CtrlDataFactory.getCtrlPartida();
		ArrayList<Partida> SP = CP.getAllPartidaJugada();
		if(SP.size()==0) throw new ExcepcioNoHiHaPartida();
		CtrlJugador CJ = CtrlDataFactory.getCtrlJugador();
		ArrayList<Jugador> SJ = CJ.getAllJugador();
		ArrayList<TuplePersPunt> ret = Joc2048.getRanking(SJ);
	}
	
}