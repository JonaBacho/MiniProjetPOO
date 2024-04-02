package core;

public class EnseignantStatutException extends Exception{
	
	public EnseignantStatutException() {
		System.out.println("Le cycle de l'étudiant est soit VACATAIRE soit PERMANANT");
	}
	
	public EnseignantStatutException(String value) {
		System.out.println("Le cycle de l'étudiant est soit VACATAIRE soit PERMANANT et nom" + value.toUpperCase());
	}

}
