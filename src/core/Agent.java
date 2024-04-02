package core;

import java.sql.Connection;
import java.util.Date;

public class Agent extends Contact{
	
	private String Statut;
	private double Salaire;
	private String Categorie;
	private int IndiceDeSalaire;
	private String occupation;
	
	public Agent() throws AgentStatutException{
		super();
		this.setCategorie(" ");
		this.setIndiceDeSalaire(0);
		this.setOccupation(" ");
		this.setSalaire(2000);
		this.setStatut("PERMANANT");
	}
	
	public Agent(String code, String nom, String dateNaissance, String adresse, String email, String telNumber, double salaire, String statut, String categorie,
			int indice, String occupation) throws AgentStatutException{
		super(code, nom, dateNaissance, adresse, email, telNumber);
		this.setCategorie(categorie);
		this.setIndiceDeSalaire(indice);
		this.setOccupation(occupation);
		this.setSalaire(salaire);
		this.setStatut(statut);
		
	}

	
	// setters et getters
	public String getStatut() {
		return Statut;
	}

	protected void setStatut(String statut) throws AgentStatutException {
		String val = statut.toUpperCase();
		if(!(val.equals("TEMPORAIRE")) && !(val.equals("STAGIAIRE")) && !(val.equals("PERMANANT"))){
			throw new AgentStatutException(statut);
		}
		else {
			this.Statut = val;
		}
		
	}

	public double getSalaire() {
		return Salaire;
	}

	protected void setSalaire(double salaire) {
		Salaire = salaire;
	}

	public String getCategorie() {
		return Categorie;
	}

	protected void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public int getIndiceDeSalaire() {
		return IndiceDeSalaire;
	}

	protected void setIndiceDeSalaire(int indiceDeSalaire) {
		IndiceDeSalaire = indiceDeSalaire;
	}

	public String getOccupation() {
		return occupation;
	}

	protected void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	// implementation de l'insertion
	public void ajouterEnBD(Connection connect) {
		// on enregistre l'objet courant en BD
	}
	
	

}
