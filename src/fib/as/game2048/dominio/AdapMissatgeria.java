package fib.as.game2048;

public class AdapMissatgeria {
	
	public void enviarMissatge(Integer id, Integer punt, String mail)
	{
		ServiceLocator SM;
		String missatge = "Partida amb id "+id+" ha obtingut "+punt+" punts";
		SM.enviarMissatge(missatge,mail);
	}
}
