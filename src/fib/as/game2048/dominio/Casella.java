package fib.as.game2048.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Alex Peregrina Cabrera
 *
 */
@Entity
@Table(name="casella")
public class Casella implements Serializable{
	
	@Id
	@Embedded
	private PrimaryKeyCasella key;
	
	@Column(name="numero")
	private Integer numero;
	
	public Casella() {
	}

	public Casella(PrimaryKeyCasella key, Integer numero) {
		this.key = key;
		this.numero = numero;
	}
	
	public Casella(Integer numeroFila, Integer numeroColumna, Integer numero) {
		
	}

	public PrimaryKeyCasella getKey() {
		return key;
	}

	public void setKey(PrimaryKeyCasella key) {
		this.key = key;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void assignarPartida(Partida partida) {
		
	}
	
	public Integer fusio(Casella casella) {
		return null;
	}
	
	public Integer getNumeroFila() {
		return null;
	}
	
	public Integer getNumeroColumna() {
		return null;
	}
	
	public Boolean esBuida() {
		return null;
	}
	
	public void copia(Casella casella) {
		
	}
	
	public Integer duplica() {
		return null;
	}
	
	public void buida() {
		
	}
}
