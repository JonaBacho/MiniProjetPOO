package core;

import java.sql.Connection;
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
		 try {
	            Statement statement = connect.createStatement();

	            // insertion de données dans la table "Enseignants"
	            String insertDataSQL = "INSERT INTO Enseignants(code, nom, dateDeNaissance, address, email, telNumber, statut) "
	            		+ "VALUES(" + this.getCode()+ ", " + this.getNom() + ", " + this.dateDeNaissanceFormate() + ", "
	            		+ this.getAddress() + ", " + this.getEmail() + ", " + this.getTelNumber() + ", " + this.getStatut() + ");";
	            
	            statement.executeUpdate(insertDataSQL);

	            System.out.println("Enseignant inseré en BD avec succes");
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
