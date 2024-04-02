package core;

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
	
	
	

}
