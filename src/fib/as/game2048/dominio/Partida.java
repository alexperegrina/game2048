package fib.as.game2048.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/**
 * 
 * @author Alex Peregrina Cabrera
 *
 */
@Entity
@Table(name="partida")
public class Partida implements Serializable{
	
	public static String MOVIMENT_AMUNT = "amunt";
	public static String MOVIMENT_AVALL = "avall";
	public static String MOVIMENT_DRETA = "dreta";
	public static String MOVIMENT_ESQUERRA = "esquerra";

	@Id
	@Column(name="idPartida")
	private Integer idPartida;
	
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jugador")
	private Jugador jugador;
	
	public Partida() {
	}

	public Partida(Integer idPartida) {
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
	}
	
	public Partida(Jugador jugador, Integer idPartida) {
		this.jugador = jugador;
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
		this.crearTaulell();
//		return caselles;
		
	}

	public Integer getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public Boolean getEstaAcabada() {
		return estaAcabada;
	}

	public void setEstaAcabada(Boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

	public Boolean getEstaGuanyada() {
		return estaGuanyada;
	}

	public void setEstaGuanyada(Boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}

	public Integer getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(Integer puntuacio) {
		this.puntuacio = puntuacio;
	}

	public ArrayList<Casella> getCaselles() {
		return caselles;
	}

	public void setCaselles(ArrayList<Casella> caselles) {
		this.caselles = caselles;
	}
	
	public ParOrdenado<String, Integer> getRanking() { // este metodo desaparecera creo
		return null;
	}
	
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
				
				if(count == c1 || count == c2) {
					valor = Util.randomInterval(2, 4);
					do {
						valor = Util.randomInterval(2, 4);
					} while (valor != 3);
				}
				
				casella = new Casella(i, j, valor, this);
				caselles.add(casella);
				
				if(count == c1 || count == c2) {
					casellesValor.add(casella);
				}
			}
		}
		
		this.caselles = caselles;
		
		return casellesValor;
	}
	
	public void sumaPuntuacio(Integer punts) {
		this.puntuacio += punts;
	}
	
	public Boolean comprovarPartidaPerduda() {
		return !(this.potMoure(MOVIMENT_AMUNT) || this.potMoure(MOVIMENT_AVALL) 
				|| this.potMoure(MOVIMENT_DRETA) || this.potMoure(MOVIMENT_ESQUERRA));
	}
	
	public Boolean comprovarPartidaGuanyada() {
		Boolean guanyada = false;
		for(int i = 0; i < this.caselles.size() && !guanyada; i++) {
			if(this.caselles.get(i).getNumero() == 2048) {
				guanyada = true;
			}
		} 
		return guanyada;
	}
	
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
	
	public ArrayList<Casella> getCasellesLliures() {
		ArrayList<Casella> casellesLliures = new ArrayList<Casella>();
		for (Casella casella : this.caselles) {
			if(casella.esBuida()) {
				casellesLliures.add(casella);
			}
		}
		return casellesLliures;
	}
	
	public ArrayList<Casella> getCasellesValor() {
		ArrayList<Casella> casellesValor = new ArrayList<Casella>();
		for (Casella casella : this.caselles) {
			if(!casella.esBuida()) {
				casellesValor.add(casella);
			}
		}
		return casellesValor;
	}
	
	public ArrayList<Casella> obteFila(Boolean ordre, Integer fila) {
		ArrayList<Casella> filaCaselles = new ArrayList<Casella>();
		for(int i = 0; i < caselles.size(); i++) {
			Integer n = caselles.get(i).getNumeroFila();
			if(n == fila) {
				filaCaselles.add(caselles.get(i));
			}
			
			/**
			 * HAY QUE MIRAR BIEN EL TEMA DEL COMPARATOR QUE LO HE HECHO SIN INTERNET *********************************
			 */
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
	
	public ArrayList<Casella> obteColumna(Boolean ordre, Integer col) {
		
		ArrayList<Casella> colCaselles = new ArrayList<Casella>();
		for(int i = 0; i < caselles.size(); i++) {
			Integer n = caselles.get(i).getNumeroColumna();
			if(n == col) {
				colCaselles.add(caselles.get(i));
			}
			
			/**
			 * HAY QUE MIRAR BIEN EL TEMA DEL COMPARATOR QUE LO HE HECHO SIN INTERNET *********************************
			 */
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
	
	public Boolean potMoure(String mov) {
		Boolean potMoute = false;
		Boolean buidaFila = false;
		Integer numFila = null;
		ArrayList<ArrayList<Casella>> lineas = obteLinies(mov);
		for(int i = 0; i < 4 && !potMoute; i++) {
			buidaFila = false;
			numFila = null;
			for(int j = 3; j >= 0 && !potMoute; j++) {
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
	
	public ArrayList<ArrayList<Casella>> obteLinies(String mov) {
		Boolean ordre = true;
		ArrayList<ArrayList<Casella>> linies = new ArrayList<ArrayList<Casella>>();
		if(mov == MOVIMENT_AMUNT || mov == MOVIMENT_ESQUERRA) {
			ordre = false;
		}
		
		for(int i = 0; i < 4; i++) {
			if(mov == MOVIMENT_AMUNT || mov == MOVIMENT_AVALL) {
				linies.add(obteColumna(ordre, i));
			}
			if(mov == MOVIMENT_DRETA || mov == MOVIMENT_ESQUERRA) {
				linies.add(obteFila(ordre, i));
			}
		}
		
		return linies;
	}
	
	public ArrayList<ArrayList<Casella>> ferMoviment(String tipusMov) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Id: " + idPartida + " -- Puntuacion: " + puntuacio;
	}
}
