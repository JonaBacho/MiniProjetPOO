package core;

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

}
