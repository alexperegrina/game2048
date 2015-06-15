package fib.as.game2048.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Jugador")
public class Jugador extends UsuariRegistrat implements Serializable {
	
	@Column(name="email")
	private String email;
	
	@Column(name="millorPuntuacio")
	private Integer millorPuntuacio;
	
	@OneToMany(mappedBy="idPartida",cascade= CascadeType.ALL)
	private ArrayList<Partida> partidaJugada;
	
	private Partida partidaActual;
	
	public Jugador()
	{
		super();
	}
	
	public Jugador(String nom, String cognoms, String pwd, String username, String email, Integer millorPuntuacio)
	{
		super(nom,cognoms,username,pwd);
		this.millorPuntuacio = millorPuntuacio;
		partidaJugada = new ArrayList<Partida>();
	}
	
	public Integer getMillorPuntuacio()
	{
		return this.millorPuntuacio;
	}
	
	public String getNom()
	{
		return super.getNom();
	}
	
	public Integer getPuntuacioMitjana()
	{
		Integer punts = 0;
		for(int i=0; i < partidaJugada.size(); ++i)
		{
			punts += partidaJugada.get(i).getPuntuacio();
			
		}
		return punts/partidaJugada.size();
	}
	public void assignarPartidaActual(Partida p)
	{
		this.partidaActual = p;
	}
	public void eliminarPartidaActual(Partida p)
	{
		this.partidaActual = null;
	}
	public void assignarPartidaJugada(Partida p)
	{
		if(p != null) this.partidaJugada.add(p);
	}
	
	public void setMillorPuncuacio(Integer punts)
	{
		this.millorPuntuacio = punts;
	}
	
	
}
