package fib.as.game2048;

public class Joc2048 {
	
	private Integer idPartida;

	public Integer getIdPartida() {
		return idPartida;
	}
	
	public Integer incrementarId()
	{
		this.idPartida = this.idPartida+1;
		return this.idPartida;
	}
	
	public void assignarEstrategia(Estrategia E)
	{}
	
	
	
}
