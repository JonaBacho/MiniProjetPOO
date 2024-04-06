package core;

import java.util.ArrayList;
import java.util.List;

public class Repertoire {
	
	private List<Contact> contacts;

    public Repertoire() {
        contacts = new ArrayList<Contact>();
    }

    // Méthode pour ajouter un contact au répertoire
    public void ajouterContact(Contact contact) {
        contacts.add(contact);
    }

    // Méthode pour supprimer un contact du répertoire
    public void supprimerContact(Contact contact) {
        contacts.remove(contact);
    }

    // Méthode pour obtenir tous les contacts du répertoire
    public List<Contact> getContacts() {
        return contacts;
    }

    // Méthode pour modifier un contact existant dans le répertoire
    public void modifierContact(Contact contactAModifier, Contact nouveauContact) {
        int index = contacts.indexOf(contactAModifier);
        if (index != -1) {
            contacts.set(index, nouveauContact);
        } else {
            System.out.println("Le contact spécifié n'existe pas dans le répertoire.");
        }
    }

    // Méthode pour rechercher un contact par son code
    public Contact rechercherContact(String code) {
        for (Contact contact : contacts) {
            if (contact.getCode().equals(code)) {
                return contact;
            }
        }
        return null; // Retourne null si le contact n'est pas trouvé
    }

}
