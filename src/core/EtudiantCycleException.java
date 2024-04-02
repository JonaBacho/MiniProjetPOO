package core;

public class EtudiantCycleException extends Exception{
	
	public EtudiantCycleException() {
		System.out.println("Le cycle de l'étudiant est soit INGENIEUR soit LICENSE");
	}
	
	public EtudiantCycleException(String value) {
		System.out.println("Le cycle de l'étudiant est soit INGENIEUR soit LICENSE et nom "+ value.toUpperCase()); 
	}

}
