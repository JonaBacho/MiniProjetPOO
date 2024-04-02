package core;

public class MainApplication {

	public static void main(String[] args) {
		
		// Création d'une instance de Repertoire
        Repertoire repertoire = new Repertoire();

        // Création de quelques contacts
        Contact contact1 = new Contact("001", "John Doe", "03/07/2000", "Adresse1", "email1@example.com", "123456789");
        Contact contact2 = new Contact("002", "Jane Smith", "10/10/2000", "Adresse2", "email2@example.com", "987654321");

        // Ajout des contacts au répertoire
        repertoire.ajouterContact(contact1);
        repertoire.ajouterContact(contact2);

        // Recherche d'un contact par son code
        String codeRecherche = "001";
        Contact contactRecherche = repertoire.rechercherContact(codeRecherche);
        if (contactRecherche != null) {
            System.out.println("Contact trouvé : " + contactRecherche);
        } else {
            System.out.println("Aucun contact trouvé avec le code " + codeRecherche);
        }

        // Modification d'un contact
        Contact nouveauContact1 = new Contact("001", "John Doe Jr.", "10/12/1998", "Nouvelle adresse", "nouvellemail@example.com", "999999999");
        repertoire.modifierContact(contact1, nouveauContact1);

        // Affichage des contacts après modification
        System.out.println("Liste des contacts après modification : ");
        for (Contact contact : repertoire.getContacts()) {
            System.out.println(contact);
        }

	}

}
