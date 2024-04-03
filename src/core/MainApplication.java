package core;

public class MainApplication {

	public static void main(String[] args) {
		
		// Création d'une instance de Repertoire
        Repertoire repertoire = new Repertoire();

        // Création de quelques contacts
        Contact contact1;
        Contact contact2;
		try {
			contact1 = new Agent();
			contact2 = new Agent();
			// Ajout des contacts au répertoire
	        repertoire.ajouterContact(contact1);
	        repertoire.ajouterContact(contact2);
	        
	     // Modification d'un contact
	        Contact nouveauContact1;
	        nouveauContact1 = new Enseignant("001", "John Doe Jr.", "10/12/1998", "Nouvelle adresse", "nouvellemail@example.com", "999999999", "PERMANANT");
			repertoire.modifierContact(contact1, nouveauContact1);

		} catch (AgentStatutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (EnseignantStatutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Recherche d'un contact par son code
        String codeRecherche = "001";
        Contact contactRecherche = repertoire.rechercherContact(codeRecherche);
        if (contactRecherche != null) {
            System.out.println("Contact trouvé : " + contactRecherche.toString());
        } else {
            System.out.println("Aucun contact trouvé avec le code " + codeRecherche.toString());
        }


        // Affichage des contacts après modification
        System.out.println("Liste des contacts après modification : ");
        for (Contact contact : repertoire.getContacts()) {
        	if(contact instanceof Agent) {
            System.out.println(contact.toString());
        	}

        }

	}
}
