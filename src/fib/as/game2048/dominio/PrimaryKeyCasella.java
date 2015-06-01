package fib.as.game2048.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PrimaryKeyCasella  implements Serializable {
	
	@Column(name="numeroFila")
	private Integer numeroFila;
	
	@Column(name="numeroColumna")
	private Integer numeroColumna;
	
	@ManyToOne
	@JoinColumn(name="idPartida")
	private Partida partida;

	public PrimaryKeyCasella() {
	}

	public PrimaryKeyCasella(Integer numeroFila, Integer numeroColumna,
			Partida partida) {
		this.numeroFila = numeroFila;
		this.numeroColumna = numeroColumna;
		this.partida = partida;
	}

	public Integer getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(Integer numeroFila) {
		this.numeroFila = numeroFila;
	}

	public Integer getNumeroColumna() {
		return numeroColumna;
	}

	public void setNumeroColumna(Integer numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	

}
