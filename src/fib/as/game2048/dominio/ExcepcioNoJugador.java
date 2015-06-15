package fib.as.game2048;

public class ExcepcioNoJugador extends Exception{
	public String getMessage()
	{
		return "L'usuari no es jugador";
	}
}
