package fib.as.game2048;

public class CtrlCasUsLogin extends CtrlCasUs{
	
	public boolean login(String userN, String passwd) throws ExcepcioPwdIncorrecte, ExcepcioLoginIncorrecte, ExcepcioNoJugador
	{
		boolean b = true;
		CtrlUsuariRegistrat CUR = CtrlDataFactory.getCtrlUsuarisRegistrats();
		UsuariRegistrat U = CUR.getUsuariRegistrat(userN);
		if(U == null) throw new ExcepcioLoginIncorrecte();
		if(!U.isPassword(passwd)) throw new ExcepcioPwdIncorrecte();
		CtrlJugador CJ = CtrlDataFactory.getCtrlJugador();
		CJ.getJugador(userN);
		return b;
	}
}
