package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Enseignant extends Contact{
	
	private String Statut;
	
	public Enseignant() throws EnseignantStatutException {
		super();
		this.setStatut("PERMANANT");
		
	}
	
	public Enseignant(String code, String nom, String dateNaissance, String adresse, String email, String telNumber, String statut)
			throws EnseignantStatutException{
        super(code, nom, dateNaissance, adresse, email, telNumber);
        this.setStatut(statut);
    }
	
	// setter et getter

	public String getStatut() {
		return this.Statut;
	}

	protected void setStatut(String statut) throws EnseignantStatutException {
		String val = statut.toUpperCase();
		if(!(val.equals("VACATAIRE")) && !(val.equals("PERMANANT"))){
			throw new EnseignantStatutException(statut);
		}
		else {
			this.Statut = val;
		}
	}
	
	// autres methodes
	// implementation de l'insertion
	public int ajouterEnBD(Connection connect) {
		 // on enregistre l'objet courant en BD
		 String insertDataSQL = "INSERT INTO Enseignants (code, nom, dateDeNaissance, address, email, telNumber, statut) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
		 try (PreparedStatement statement = connect.prepareStatement(insertDataSQL)) {
		     statement.setString(1, this.getCode());
		     statement.setString(2, this.getNom());
		     statement.setString(3, this.dateDeNaissanceForBD());
		     statement.setString(4, this.getAddress());
		     statement.setString(5, this.getEmail());
		     statement.setString(6, this.getTelNumber());
		     statement.setString(7, this.getStatut());
		     
		     statement.executeUpdate();
		     System.out.println("Etudiant inseré en BD avec succes");
		     return 0;
		 } catch (SQLException e) {
		     e.printStackTrace();
		     return -1;
		 }
	}
	
	public String toString() {
		return "Etudiant " + this.getCode()+ ", " + this.getNom() + ", " + this.dateDeNaissanceFormate() + ", "
        		+ this.getAddress() + ", " + this.getEmail() + ", " + this.getTelNumber() + ", " + this.getStatut();
	}
		
		

}
