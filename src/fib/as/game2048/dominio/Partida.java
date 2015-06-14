package fib.as.game2048;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public Partida() {
	}

	public Partida(Jugador jugador, Integer idPartida) {
		this.idPartida = idPartida;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.puntuacio = 0;
		this.jugador = jugador;
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
	
}
