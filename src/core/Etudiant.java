package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Etudiant extends Contact{
	
	private String cycle;
	private String Niveau;
	
	public Etudiant() throws EtudiantCycleException {
		super();
		this.setCycle("License");
		this.setNiveau("1");
		
	}
	
	public Etudiant(String code, String nom, String dateNaissance, String adresse, String email, String telNumber, String cycle, String niveau)
			throws EtudiantCycleException{
        super(code, nom, dateNaissance, adresse, email, telNumber);
        this.setCycle(cycle);
        this.setNiveau(niveau);
    }
	
	// setter et getter

	public String getCycle() {
		return this.cycle;
	}

	protected void setCycle(String cycle) throws EtudiantCycleException {
		String val = cycle.toUpperCase();
		if(!(val.equals("INGENIEUR")) && !(val.equals("LICENSE"))){
			throw new EtudiantCycleException(cycle);
		}
		else {
			this.cycle = val;
		}
	}

	public String getNiveau() {
		return Niveau;
	}

	protected void setNiveau(String niveau) {
		Niveau = niveau;
	}
	
	
	// autres methodes
	public int ajouterEnBD(Connection connect) {
		 // on enregistre l'objet courant en BD
		 String insertDataSQL = "INSERT INTO Etudiants (code, nom, dateDeNaissance, address, email, telNumber, cycle, niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
		 try (PreparedStatement statement = connect.prepareStatement(insertDataSQL)) {
		     statement.setString(1, this.getCode());
		     statement.setString(2, this.getNom());
		     statement.setString(3, this.dateDeNaissanceForBD());
		     statement.setString(4, this.getAddress());
		     statement.setString(5, this.getEmail());
		     statement.setString(6, this.getTelNumber());
		     statement.setString(7, this.getCycle());
		     statement.setString(8, this.getNiveau());
		     
		     statement.executeUpdate();
		     System.out.println("Etudiantt inseré en BD avec succes");
		     return 0;
		 } catch (SQLException e) {
		     e.printStackTrace();
		     return -1;
		 }
	}
	
	public String toString() {
		return "Etudiant " + this.getCode()+ ", " + this.getNom() + ", " + this.dateDeNaissanceFormate() + ", "
        		+ this.getAddress() + ", " + this.getEmail() + ", " + this.getTelNumber() + ", " + this.getCycle() + ", " 
        		+ this.getNiveau();
	}
	

}
