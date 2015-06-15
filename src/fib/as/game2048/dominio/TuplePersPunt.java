package fib.as.game2048.dominio;

public class TuplePersPunt {
	
	private String nom;
	private Integer punt;
	
	public TuplePersPunt(){}
	
	public TuplePersPunt(String nom, Integer punt)
	{
		this.nom = nom;
		this.punt = punt;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPunt() {
		return punt;
	}

	public void setPunt(Integer punt) {
		this.punt = punt;
	}
}
