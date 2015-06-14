package fib.as.game2048;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	private static int randInt(int min, int max)
	{
		Random rand = new Random();
		int randomnum = rand.nextInt((max-min)+1)+min;
		return randomnum;
	}
	
	public ArrayList crearTaulell()
	{
		Integer i = 0;
		Integer j = 0;
		Integer c1 = randInt(0,15);
		Integer c2 = randInt(0,15);
		while(c1 == c2) c2 = randInt(0,15);
		Integer count = null;
		caselles = new ArrayList<Casella>();
		ArrayList<Casella> casellesValor = new ArrayList<Casella>();
		while(i<4)
		{
			j=0;
			count = null;
			while(j<4)
			{
				Integer valor;
				if(count == c1 || count == c2)
				{
					valor = randInt(1,2)*2;
				}
				else valor = null;
				Casella C = new Casella(i,j,valor,partida);
				//No entiendo como asignar partida dentro de partida
				caselles.add(C);
				if(count == c1 || count == c2) casellesValor.add(C);
				++j;
				++count;
			}
			++i;
		}
		return casellesValor;
		//No entiendo que es casellesValor.
		//Si es el valor, deduzco que deberiamos 
		//Guardar el valor, no la casilla
	}
	
	public void sumaPuntuacio(Integer punts)
	{
		this.puntuacio += punts;
	}
	
	public void potMoure(String mov)
	{
		ArrayList<Casella> linies = new ArrayList<Casella>();
		boolean potMoure = false;
		Integer i = 0, j = 0;
		while(i<4 and !potMoure)
		{
			boolean buidaFila = false;
			Integer numFila = null;
			//Tengo mis dudas de si es j = 4 y restar o j = 0 y sumar.
			while(j<4 and !potMoure)
			{
				if(linies.isEmpty()) buidaFila=true;
				if(buidaFila == true) potMoure = true;
				else
				{
				//	Integer n = linies.get(i/j).getNumero()
					if (n == numFila) potMoure=true;
					else numFila = n;
				}
			}
		}
	}
	
	public void obteLinies(String mov)
	{
		
		
	}
	
	
}
