package fib.as.game2048;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="casella")
public class Casella implements Serializable{
	
	@Id
	@Embedded
	private PrimaryKeyCasella key;
	
	@Column(name="numero")
	private Integer numero;
	
<<<<<<< HEAD
	/**
	 * Constructor vacio
	 */
=======
	private Partida P;
	
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	public Casella() {
	}

	/**
	 * Constructor que se le pasa la Key y el valor
	 * @param key PrumaryKeyCasella
	 * @param numero Integer
	 */
	public Casella(PrimaryKeyCasella key, Integer numero) {
		this.key = key;
		this.numero = numero;
	}
	
<<<<<<< HEAD
	/**
	 * Constructor que se le pasa la fila, columna, y el valor
	 * @param numeroFila Integer
	 * @param numeroColumna Integer
	 * @param numero Integer
	 */
	public Casella(Integer numeroFila, Integer numeroColumna, Integer numero) {
		this.numero = numero;
		this.key = new PrimaryKeyCasella(numeroFila, numeroColumna);
	}
	
	//CONTRUCTURA QUE SI NO SE UTILIZA LA PODEMOS QUITAR YA QUE
	// NO HA SIDO DEFINIDA EN LA ESPECIFICACIÓN
	/**
	 * Constructora que se le pasa la fila, columna, valor y la partida para asignarla en la misma constructora.
	 * @param numeroFila Integer
	 * @param numeroColumna Integer
	 * @param numero Integer
	 * @param partida Partida
	 */
	public Casella(Integer numeroFila, Integer numeroColumna, Integer numero, Partida partida) {
		this.numero = numero;
		this.key = new PrimaryKeyCasella(numeroFila, numeroColumna, partida);
=======
	public Casella(Integer i, Integer j, Integer numero, Partida P) {
		this.key.setNumeroFila(i);
		this.key.setNumeroColumna(j);
		this.numero = numero;
		this.P = P;
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	}

	/**
	 * Consultamos la primaryKey
	 * @return PrimaryKeyCasella
	 */
	private PrimaryKeyCasella getKey() {
		return key;
	}

	/**
	 * Modificamos primaryKey
	 * @param key PrimaryKeyCasella
	 */
	private void setKey(PrimaryKeyCasella key) {
		this.key = key;
	}

	/**
	 * Consultamos el valor de la casilla
	 * @return Integer
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Modificamos el valor de la casilla
	 * @param numero Integer
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
<<<<<<< HEAD
	/**
	 * Asignamos una Partida a la casilla.
	 * @param partida Partida
	 */
	public void assignarPartida(Partida partida) {
		this.key.setPartida(partida);
	}
	
	/**
	 * Metodo para fusionar dos casillas, la casilla que se le pasa como parametro contendra el valor de la fusion de 
	 * las dos casillas,  la casilla propietaria del metodo se le asigna valor null.
	 * @param casella PrimaryKeyCasella
	 * @return Integer, valor se la fusion de las dos casillas.
	 */
	public Integer fusio(Casella casella) {
		
		Integer punts = 0;
		if(casella.esBuida()) {
			casella.copia(this);
			this.buida();
		}
		else {			
//			System.out.print("num1: " + this.numero + " ");
//			System.out.print("num2: " + casella.getNumero() + " ");
//			System.out.print("==: " + this.numero == casella.getNumero() + " ");
//			System.out.println("");
			if(!casella.esBuida() && this.numero == casella.getNumero()) {
				punts = casella.duplica();
				this.buida();
			}
		}
		
		return punts;
	}
	
	/**
	 * Consultamos la fila de la casilla 
	 * @return Integer
	 */
	public Integer getNumeroFila() {
		return this.key.getNumeroFila();
	}
	
	/**
	 * Consultamos la columna de la casilla
	 * @return Integer
	 */
	public Integer getNumeroColumna() {
		return this.key.getNumeroColumna();
=======
	public Integer getNumeroFila()
	{
		return key.getNumeroFila();
	}
	
	public Integer getNumeroColumna()
	{
		return key.getNumeroColumna();
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	}
	
	/**
	 * Consultamos si la casilla no tiene ningun valor
	 * @return Boolean, true si esta vacia, false no esta vacia.
	 */
	public Boolean esBuida() {
		return this.numero == null;
	}
	
<<<<<<< HEAD
	/**
	 * Metodo para realizar una copia de la casilla que se pasa como parametro
	 * @param casella, casilla a copiar.
	 */
	public void copia(Casella casella) {
		this.numero = casella.getNumero();
	}
	
	/**
	 * Metodo para multiplicar por 2 el valor de la casilla
	 * @return
	 */
	public Integer duplica() {
		this.numero *= 2;
		return this.numero;
	}
	
	/**
	 * Metodo para vaciar el valor de la casilla
	 */
	public void buida() {
		numero = null;
	}
	
	@Override
	public String toString() {
		return "fila: " + this.getNumeroFila() + " columna: " + this.getNumeroColumna() + " numero: " + this.getNumero();
	}
=======
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
}
