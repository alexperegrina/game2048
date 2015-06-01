package fib.as.game2048.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private List<Casella> caselles;
	
	public Partida() {
	}

	public Partida(Integer idPartida) {
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
	}
	
	public Partida(Jugador jugador, Integer idPartida) {
		
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

	public List<Casella> getCaselles() {
		return caselles;
	}

	public void setCaselles(List<Casella> caselles) {
		this.caselles = caselles;
	}
	
	public ParOrdenado<String, Integer> getRanking() {
		return null;
	}
	
	public ArrayList<Casella> crearTaulell() {
		return null;
	}
	
	public void sumaPuntuacio(Integer punts) {
		
	}
	
	public Boolean comprovarPartidaPerduda() {
		return null;
	}
	
	public Boolean comprovarPartidaGuanyada() {
		return null;
	}
	
	public void preparaSeguentMoviment() {
		
	}
	
	public ArrayList<Casella> getCasellesValor() {
		return null;
	}
	
	public ArrayList<Casella> obteFila(Boolean ordre, Integer fila) {
		return null;
	}
	
	public ArrayList<Casella> obteColumna(Boolean ordre, Integer col) {
		return null;
	}
	
	public Boolean potMoure(String mov) {
		return null;
	}
	
	public ArrayList<Casella> obteLinea(String mov) {
		return null;
	}
	
	public ArrayList<Casella> obteCasellesLliures() {
		return null;
	}
	
	public ArrayList<ArrayList<Casella>> ferMoviment(String tipusMov) {
		return null;
	}
}
