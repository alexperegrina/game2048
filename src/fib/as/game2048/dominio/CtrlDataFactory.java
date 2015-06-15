package fib.as.game2048.dominio;

public final class CtrlDataFactory {
	
	public static CtrlUsuariRegistrat getCtrlUsuarisRegistrats()
	{
		return new CtrlUsuariRegistrat();
	}
	
	public static CtrlPartida getCtrlPartida()
	{
		return new CtrlPartida();
	}
	
	public static CtrlJugador getCtrlJugador()
	{
		return new CtrlJugador();
	}
	
	public static CtrlCasUsLogin getCtrlCasUsLogin()
	{
		return new CtrlCasUsLogin();
	}
	
	public static CtrlCasUsRanking getCtrlCasUsRanking()
	{
		return new CtrlCasUsRanking();
	}
}
