package fib.as.game2048;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="UsuariRegistrat")
public class UsuariRegistrat {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="cognoms")
	private String cognoms;
	
	@Column(name="pwd")
	private String pwd;
	
	public UsuariRegistrat(){}
	
	public UsuariRegistrat(String nom, String cognoms, String username,
			String pwd)
	{
		this.nom = nom;
		this.cognoms = cognoms;
		this.username = username;
		this.pwd = pwd;
	}
	
	public Boolean isPassword(String passwd)
	{
		if (this.pwd == passwd) return true;
		return false;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
}    
