package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Agent extends Contact{
	
	private String Statut;
	private double Salaire;
	private String Categorie;
	private int IndiceDeSalaire;
	private String occupation;
	
	public Agent() throws AgentStatutException{
		super();
		this.setCategorie("agent c");
		this.setIndiceDeSalaire(0);
		this.setOccupation("agent c");
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
	public int ajouterEnBD(Connection connect) {
		// on enregistre l'objet courant en BD
		 String insertDataSQL = "INSERT INTO Agents (code, nom, dateDeNaissance, address, email, telNumber, salaire, statut, categorie, indice, occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		 try (PreparedStatement statement = connect.prepareStatement(insertDataSQL)) {
		     statement.setString(1, this.getCode());
		     statement.setString(2, this.getNom());
		     statement.setString(3, this.dateDeNaissanceForBD());
		     statement.setString(4, this.getAddress());
		     statement.setString(5, this.getEmail());
		     statement.setString(6, this.getTelNumber());
		     statement.setDouble(7, this.getSalaire());
		     statement.setString(8, this.getStatut());
		     statement.setString(9, this.getCategorie());
		     statement.setInt(10, this.getIndiceDeSalaire());
		     statement.setString(11, this.getOccupation());
		     
		     statement.executeUpdate();
		     System.out.println("Agent inseré en BD avec succes");
		     return 0;
		 } catch (SQLException e) {
		     e.printStackTrace();
		     return -1;
		 }
	}
	
	public String toString() {
		return "Agent " + this.getCode()+ ", " + this.getNom() + ", " + this.dateDeNaissanceFormate() + ", "
        		+ this.getAddress() + ", " + this.getEmail() + ", " + this.getTelNumber() + ", " + this.getSalaire() + ", " 
        		+ this.getStatut() + ", " + this.getCategorie() + ", " + this.getIndiceDeSalaire() + ", "
        		+ this.getOccupation();
	}
	
	

}
