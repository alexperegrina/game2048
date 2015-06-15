package fib.as.game2048;

import java.io.Serializable;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Collections;
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import fib.as.game2048.CtrlCasUsJugarPartida.ordenaporcolumna;
import fib.as.game2048.CtrlCasUsJugarPartida.ordenaporcolumnainversa;
import fib.as.game2048.CtrlCasUsJugarPartida.ordenaporfila;
import fib.as.game2048.CtrlCasUsJugarPartida.ordenaporfilainversa;

@Entity
@Table(name="partida")
public class Partida implements Serializable{
	
	public static String MOVIMENT_AMUNT = "amunt";
	public static String MOVIMENT_AVALL = "avall";
	public static String MOVIMENT_DRETA = "dreta";
	public static String MOVIMENT_ESQUERRA = "esquerra";

	@Id
	private Integer idPartida;

	@ManyToOne
	private Jugador jugador;
	
	@Column(name="estaAcabada")
	private Boolean estaAcabada;
	
	@Column(name="estaGuanyada")
	private Boolean estaGuanyada;
	
	@Column(name="puntuacio")
	private Integer puntuacio;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="idPartida")
	@IndexColumn(name="idx")
	private ArrayList<Casella> caselles;
<<<<<<< HEAD
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jugador")
	private Jugador jugador;
=======
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	
	/**
	 * Constructora vacia
	 */
	public Partida() {
	}

<<<<<<< HEAD
	/**
	 * Constructora pasandole idPartida
	 * @param idPartida Integer
	 */
	public Partida(Integer idPartida) {
=======
	public Partida(Jugador jugador, Integer idPartida) {
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
<<<<<<< HEAD
	}
	
	/**
	 * Constructora de Partida donde se crea un tablero de 4X4 casillas, 
	 * ademas se le asigna a la partida el jugador pasado como parametro
	 * @param jugador Jugador
	 * @param idPartida Integer
	 */
	public Partida(Jugador jugador, Integer idPartida) {
		this.jugador = jugador;
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
		this.crearTaulell();
//		return caselles;
		
=======
		this.jugador = jugador;
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	}

	/**
	 * Consultamos el id de la partida
	 * @return
	 */
	public Integer getIdPartida() {
		return idPartida;
	}

	/**
	 * Modificamos el id de la partida
	 * @param idPartida Integer
	 */
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	/**
	 * Consultamos la variable estaAcabada
	 * @return true si esta acabada, false si no
	 */
	public Boolean getEstaAcabada() {
		return estaAcabada;
	}

	/**
	 * Modificamos la variable estaAcabada
	 * @param estaAcabada Boolean
	 */
	public void setEstaAcabada(Boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

	/**
	 * Consultamos la variable estaGuanyada
	 * @return true si esta guanyada, false si no
	 */
	public Boolean getEstaGuanyada() {
		return estaGuanyada;
	}

	/**
	 * Modificamos la variable estaGuanyada
	 * @param estaGuanyada Boolean
	 */
	public void setEstaGuanyada(Boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}

	/**
	 * Consultamos la puntuación de la partida
	 * @return Integer
	 */
	public Integer getPuntuacio() {
		return puntuacio;
	}

	/**
	 * Modificamos la puntuación de la partida
	 * @param puntuacio Integer
	 */
	public void setPuntuacio(Integer puntuacio) {
		this.puntuacio = puntuacio;
	}

<<<<<<< HEAD
	/**
	 * Consultamos las casellas de la partida
	 * @return ArrayList<Casella>
	 */
=======
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	public ArrayList<Casella> getCaselles() {
		return caselles;
	}

<<<<<<< HEAD
	/**
	 * Modificamos el vector de casillas de la partida
	 * @param caselles ArrayList<Casella>
	 */
=======
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
	public void setCaselles(ArrayList<Casella> caselles) {
		this.caselles = caselles;
	}
	
<<<<<<< HEAD
	/**
	 * Metodo para crear las 16 casillas que forman la partida, ademas dos de las casillas tiene un valor(2,4) las demas
	 * casillas tiene valor null.
	 * @return ArrayList<Casella> son las casillas que se les ha asignado valor.
	 */
	public ArrayList<Casella> crearTaulell() {
		Integer count = 0;
		Integer valor = null;
		Casella casella;
		ArrayList<Casella> caselles = new ArrayList<Casella>();
		ArrayList<Casella> casellesValor = new ArrayList<Casella>();
		Integer c1 = Util.randomInterval(0, 15);
		Integer c2;
		do {			
			c2 = Util.randomInterval(0, 15);
		} while (c2 == c1);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				valor = null;
				if(count == c1 || count == c2) {
					valor = Util.randomInterval(1, 2) * 2;
				}
				
				casella = new Casella(i, j, valor, this);
				caselles.add(casella);
				
				if(count == c1 || count == c2) {
					casellesValor.add(casella);
				}
				count++;
			}
		}
		
		this.caselles = caselles;
		
		return casellesValor;
	}
	
	/**
	 * Metodo que incrementa la puntuación
	 * @param punts Integer
	 */
	public void sumaPuntuacio(Integer punts) {
		this.puntuacio += punts;
	}
	
	/**
	 * Metodo que comprueva si la partida esta perdia, no puede realizar ningun movimiento.
	 * @return true si ha perdido la partida, false no ha perdido la partida
	 */
	public Boolean comprovarPartidaPerduda() {
		return !(this.potMoure(MOVIMENT_AMUNT) || this.potMoure(MOVIMENT_AVALL) 
				|| this.potMoure(MOVIMENT_DRETA) || this.potMoure(MOVIMENT_ESQUERRA));
	}
	
	/**
	 * Metodo que comprueva si la partida esta ganada, si alguna casilla tiene el valor 2048
	 * @return true si ha ganado la partida, false no ha ganado la partida.
	 */
	public Boolean comprovarPartidaGuanyada() {
		Boolean guanyada = false;
		for(int i = 0; i < this.caselles.size() && !guanyada; i++) {
			if(this.caselles.get(i).getNumero() != null &&
					this.caselles.get(i).getNumero() == 2048) {
				guanyada = true;
			}
		} 
		return guanyada;
	}
	
	/**
	 * Metodo para generar una nueva casilla con valor(2,4) eligiendo del conjunto de casillas que no tiene valor.
	 */
	public void preparaSeguentMoviment() {
		ArrayList<Casella> casellesLliures = this.getCasellesLliures();
		Integer nova = Util.randomInterval(0, casellesLliures.size()-1);
		Casella casella = casellesLliures.get(nova);
		Boolean trobat = false;
		for(int i = 0; i < this.caselles.size() && !trobat; i++) {
			if(this.caselles.get(i).getNumeroFila() == casella.getNumeroFila() && 
					this.caselles.get(i).getNumeroColumna() == casella.getNumeroColumna()) {
				this.caselles.get(i).setNumero((Util.randomInterval(1, 2)*2));
				trobat = true;
			}
		}
	}
	
	/**
	 * Metodo para consultar las casillas que no tiene ningun valor asignado.
	 * @return ArrayList<Casella> 
	 */
	public ArrayList<Casella> getCasellesLliures() {
		ArrayList<Casella> casellesLliures = new ArrayList<Casella>();
		for (Casella casella : this.caselles) {
			if(casella.esBuida()) {
				casellesLliures.add(casella);
			}
		}
		return casellesLliures;
	}
	
	/**
	 * Metodo para consultar las casillas que tiene un valor asignado.
	 * @return ArrayList<Casella> 
	 */
	public ArrayList<Casella> getCasellesValor() {
		ArrayList<Casella> casellesValor = new ArrayList<Casella>();
		for (Casella casella : this.caselles) {
			if(!casella.esBuida()) {
				casellesValor.add(casella);
			}
		}
		return casellesValor;
	}
	
	/**
	 * Metodo para consultar la fila indicada en un orden indicado.
	 * @param ordre, true --> orden original de la fila, false --> inverso de la fila
	 * @param fila, valor [0..3]
	 * @return ArrayList<Casella>
	 */
	public ArrayList<Casella> obteFila(Boolean ordre, Integer fila) {
		ArrayList<Casella> filaCaselles = new ArrayList<Casella>();
		for(int i = 0; i < caselles.size(); i++) {
			Integer n = caselles.get(i).getNumeroFila();
			if(n == fila) {
				filaCaselles.add(caselles.get(i));
			}
			
			filaCaselles.sort(new Comparator<Casella>() {
				@Override
				public int compare(Casella c1, Casella c2) {
					if(ordre) {
						return c2.getNumeroColumna() - c1.getNumeroColumna();
					}
					else {
						return c1.getNumeroColumna() - c2.getNumeroColumna();
					}
					
				}
			});
		} 
		return filaCaselles;
	}
	
	/**
	 * Metodo para consultar la columna indicada en un orden indicado.
	 * @param ordre, true --> orden original de la fila, false --> inverso de la fila
	 * @param col, valor [0..3]
	 * @return ArrayList<Casella>
	 */
	public ArrayList<Casella> obteColumna(Boolean ordre, Integer col) {
		
		ArrayList<Casella> colCaselles = new ArrayList<Casella>();
		for(int i = 0; i < caselles.size(); i++) {
			Integer n = caselles.get(i).getNumeroColumna();
			if(n == col) {
				colCaselles.add(caselles.get(i));
			}
			
			colCaselles.sort(new Comparator<Casella>() {
				@Override
				public int compare(Casella c1, Casella c2) {
					if(ordre) {
						return c2.getNumeroFila() - c1.getNumeroFila();
					}
					else {
						return c1.getNumeroFila() - c2.getNumeroFila();
					}
					
				}
			});
		} 
		return colCaselles;
	}
	
	/**
	 * Metodo para consultar si se puede realizar el movimiento indicado. tiene en cuenta si hay espacios en blanco o
	 * si se puede fusionar con otra casill.
	 * @param mov, String (amunt,avall,dreta,esquerra)
	 * @return Boolean, true si puede hacer el movimiento, false no puede hacer el movimiento.
	 */
	public Boolean potMoure(String mov) {
//		System.out.println("Mov: " + mov);
		Boolean potMoute = false;
		Boolean buidaFila = false;
		Integer numFila = null;
		ArrayList<ArrayList<Casella>> lineas = obteLinies(mov);
		
		
//		// DEBUG
//		for(int i = 0; i < lineas.size(); i++) {
//			for(int j = 0; j < lineas.get(i).size(); j++) {
//				System.out.println(lineas.get(i).get(j));
//			}
//		}
//		// DEBUG		
//		System.out.println("---------");
		
		for(int i = 0; i < 4 && !potMoute; i++) {
			// DEBUG
//			System.out.println("I: " +Integer.toString(i));
			
			buidaFila = false;
			numFila = null;
			for(int j = 3; j >= 0 && !potMoute; j--) {
				// DEBUG
//				System.out.println("J: " +Integer.toString(j));
				
				if(lineas.get(i).get(j).esBuida()) {
					buidaFila = true;
				}
				else {
					if(buidaFila == true) {
						potMoute = true;
					}
					else {
						if(lineas.get(i).get(j).getNumero() == numFila) {
							potMoute = true;
						}
						else {
							numFila = lineas.get(i).get(j).getNumero();
						}
					}
				}
			} 
		}
		return potMoute;
	}
	
	/**
	 * Metodo para obtener la matriz de casella distribuido segun el movimiento.
	 * @param mov, String (amunt,avall,dreta,esquerra)
	 * @return ArrayList<ArrayList<Casella>>
	 */
	public ArrayList<ArrayList<Casella>> obteLinies(String mov) {
		Boolean ordre = false;
		ArrayList<ArrayList<Casella>> linies = new ArrayList<ArrayList<Casella>>();
		if(mov == MOVIMENT_AMUNT || mov == MOVIMENT_ESQUERRA) {
			ordre = true;
		}
		
		for(int i = 0; i < 4; i++) {
			if(mov == MOVIMENT_AMUNT || mov == MOVIMENT_AVALL) {
				linies.add(obteColumna(ordre, i));
			}
			if(mov == MOVIMENT_DRETA || mov == MOVIMENT_ESQUERRA) {
				linies.add(obteFila(ordre, i));
			}
		}
		
//		System.out.println("Size linies: "+Integer.toString(linies.size()));
		return linies;
	}

	@Override
	public String toString() {
		return "Id: " + idPartida + " -- Puntuacion: " + puntuacio;
	}
=======
	public class ordenaporfila implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella1.getNumeroFila().compareTo(new Integer(casella2.getNumeroFila())));
		}
	}
	
	public class ordenaporfilainversa implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella2.getNumeroFila().compareTo(new Integer(casella1.getNumeroFila())));
		}
	}
	
	public class ordenaporcolumna implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella1.getNumeroColumna().compareTo(new Integer(casella2.getNumeroColumna())));
		}
	}
	
	public class ordenaporcolumnainversa implements Comparator<Casella>
	{
		@Override
		public int compare(Casella casella1, Casella casella2)
		{
			return new Integer(casella2.getNumeroColumna().compareTo(new Integer(casella1.getNumeroColumna())));
		}
	}
	
	public ArrayList obteFila(boolean ordre, Integer fila)
	{
		ArrayList<Casella>filaCaselles = new ArrayList<Casella>();
		Integer i = 0;
		while(i<caselles.size())
		{
			Integer n = caselles.get(i).getNumeroFila();
			if(n == fila) filaCaselles.add(caselles.get(i));
			++i;
		}
		Collections.sort(filaCaselles, new ordenaporfila());
		if(ordre == true) Collections.sort(filaCaselles, new ordenaporfilainversa());
		return filaCaselles;
	}
	
	public ArrayList obteCol(boolean ordre, Integer col)
	{
		ArrayList<Casella> colCaselles = new ArrayList<Casella>();
		Integer i = 0;
		while(i<caselles.size())
		{
			Integer n = caselles.get(i).getNumeroColumna();
			if(n == col) colCaselles.add(caselles.get(i));
			++i;
		}
		Collections.sort(colCaselles, new ordenaporcolumna());
		if(ordre == true) Collections.sort(colCaselles, new ordenaporcolumnainversa());
		return colCaselles;
	}
	
>>>>>>> 86d563437bddcb4bf281d84dd6d9295d5c19422f
}
