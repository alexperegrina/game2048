package fib.as.game2048;

public class CtrlCasUsLogin extends CtrlCasUs{
	
	public boolean login(String userN, String passwd) throws ExcepcioPwdIncorrecte
	{
		boolean b = true;
		CtrlUsuariRegistrat CUR = CtrlDataFactory.getCtrlUsuarisRegistrats();
		UsuariRegistrat U = CUR.get(userN);
		if(!U.isPassword(passwd)) throw new ExcepcioPwdIncorrecte();
		return b;
	}
}
