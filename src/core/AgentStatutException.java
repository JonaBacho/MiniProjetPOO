package core;

public class AgentStatutException extends Exception{
	
	public AgentStatutException() {
		System.out.println("Le cycle de l'étudiant est soit TEMPORAIRE soit STAGIAIRE soit PERMANANT");
	}
	
	public AgentStatutException(String value) {
		System.out.println("Le cycle de l'étudiant est soit TEMPORAIRE soit STAGIAIRE soit PERMANANT et nom " + value.toUpperCase());
	}
}
