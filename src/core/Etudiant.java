package core;

import java.sql.Connection;
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
		 try {
	            Statement statement = connect.createStatement();

	            // insertion de données dans la table "Etudiants"
	            String insertDataSQL = "INSERT INTO Etudiants(code, nom, dateDeNaissance, address, email, telNumber, cycle, niveau) "
	            		+ "VALUES(" + this.getCode()+ ", " + this.getNom() + ", " + this.dateDeNaissanceFormate() + ", "
	            		+ this.getAddress() + ", " + this.getEmail() + ", " + this.getTelNumber() + ", " + this.getCycle() + ", "
	            		+ this.getNiveau() + ");";
	            
	            statement.executeUpdate(insertDataSQL);

	            System.out.println("Etudiant inseré en BD avec succes");
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
