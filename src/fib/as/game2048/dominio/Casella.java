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
		this.numero = numero;
		this.key = new PrimaryKeyCasella(numeroFila, numeroColumna);
	}
	
	//CONTRUCTURA QUE SI NO SE UTILIZA LA PODEMOS QUITAR YA QUE
	// NO HA SIDO DEFINIDA EN LA ESPECIFICACIÓN
	public Casella(Integer numeroFila, Integer numeroColumna, Integer numero, Partida partida) {
		this.numero = numero;
		this.key = new PrimaryKeyCasella(numeroFila, numeroColumna, partida);
	}

	private PrimaryKeyCasella getKey() {
		return key;
	}

	private void setKey(PrimaryKeyCasella key) {
		this.key = key;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void assignarPartida(Partida partida) {
		this.key.setPartida(partida);
	}
	
	//ALEX: METODO A COMPROVAR A CONCIENCA PORQUE CREO QUE NO HACE LO QUE ESPERAMOS
	public Integer fusio(Casella casella) {
		
		Integer punts = 0;
		if(casella.esBuida()) {
			casella.copia(this);
		}
		if(!casella.esBuida() && this.numero == casella.getNumero()) {
			punts = casella.duplica();
			this.buida();
		}
		
		return punts;
	}
	
	public Integer getNumeroFila() {
		return this.key.getNumeroFila();
	}
	
	public Integer getNumeroColumna() {
		return this.key.getNumeroColumna();
	}
	
	public Boolean esBuida() {
		return this.numero == null;
	}
	
	public void copia(Casella casella) {
		this.numero = casella.getNumero();
	}
	
	public Integer duplica() {
		this.numero *= 2;
		return this.numero;
	}
	
	public void buida() {
		numero = null;
	}
	
	@Override
	public String toString() {
		return "fila: " + this.getNumeroFila() + " columna: " + this.getNumeroColumna() + " numero: " + this.getNumero();
	}
}
