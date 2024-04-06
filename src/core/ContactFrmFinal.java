package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ContactFrmFinal extends TemplateFrm{
	
	private JLabel title;
	private JLabel salaireLabel;
	private JLabel statutLabel;
	private JLabel categorieLabel;
	private JLabel indiceLabel;
	private JLabel occupationLabel;
	
	private JTextField salaireField;
	private JTextField categorieField;
	private JTextField indiceField;
	private JTextField occupationField;
	
	private JRadioButton temporaire;
	private JRadioButton stagiaire;
	private JRadioButton permanant;
	private ButtonGroup groupstatut;
	
	private JButton registerButton;
	
	public ContactFrmFinal(Repertoire repertoireCourant, String type, String code, String nom, String dateDeNaissance, String address, 
			String email, String telNumber) {
		super("creation d'un nouvel " + type, 1080, 720);
		// Initialisation des composants
		title = new JLabel("Finalisation de la creation de l'" + type);
		title.setBounds(350, 10 , 800, 60);
		title.setFont(titleFont);
		panel.add(title);
		
		// la position du boutton ne changera pas
		registerButton = new JButton("Ajouter au repertoirer");
        registerButton.setBounds(450, 600, 200, 30);
        panel.add(registerButton);
		
		// on agit en fonction du type choisit au formulaire precedent
		if (type.toUpperCase().equals("AGENT")) {
			salaireLabel = new JLabel("Salaire:");
	        salaireLabel.setBounds(50, 100, 200, 60);
	        salaireLabel.setFont(itemFont);
	        panel.add(salaireLabel);
	        
	        categorieLabel = new JLabel("Categorie:");
	        categorieLabel.setBounds(50, 170, 200, 60);
	        categorieLabel.setFont(itemFont);
	        panel.add(categorieLabel);
	        
	        indiceLabel = new JLabel("Indice de salaire");
	        indiceLabel.setBounds(50, 240, 200, 60);
	        indiceLabel.setFont(itemFont);
	        panel.add(indiceLabel);
	        
	        occupationLabel = new JLabel("Occupation:");
	        occupationLabel.setBounds(50, 310, 200, 60);
	        occupationLabel.setFont(itemFont);
	        panel.add(occupationLabel);
	        
	        
	        salaireField = new JTextField();
	        salaireField.setBounds(310, 100, 600, 60);
	        panel.add(salaireField);
	        
	        categorieField = new JTextField();
	        categorieField.setBounds(310, 170, 600, 60);
	        panel.add(categorieField);
	        
	        indiceField = new JTextField();
	        indiceField.setBounds(310, 240, 600, 60);
	        panel.add(indiceField);
	        
	        occupationField = new JTextField();
	        occupationField.setBounds(310, 310, 600, 60);
	        panel.add(occupationField);
	        
	        // Bouton radion
	        statutLabel = new JLabel("Statut:");
	        statutLabel.setBounds(50, 380, 200, 60);
	        statutLabel.setFont(itemFont);
	        panel.add(statutLabel);
	        
	        temporaire = new JRadioButton("Temporaire");
	        temporaire.setBounds(310, 380, 200, 60);
	        temporaire.setBackground(color);
	        panel.add(temporaire);
	        
	        stagiaire = new JRadioButton("Stagiaire");
	        stagiaire.setBounds(530, 380, 200, 60);
	        stagiaire.setBackground(color);
	        panel.add(stagiaire);
	        
	        permanant = new JRadioButton("Permanant");
	        permanant.setBounds(750, 380, 200, 60);
	        permanant.setBackground(color);
	        panel.add(permanant);
	        
	        groupstatut = new ButtonGroup();
	        groupstatut.add(permanant);
	        groupstatut.add(stagiaire);
	        groupstatut.add(temporaire);
	        
	        // configuration de l'action du bouton
	        registerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String categorie, occupation, statut="", salairetext, indicetext;
					salairetext = salaireField.getText();
					indicetext = indiceField.getText();
					categorie = categorieField.getText();
					occupation = occupationField.getText();
					boolean empty = !(salairetext.isBlank()) && !(categorie.isBlank()) && !(indicetext.isBlank()) && !(occupation.isBlank());
					// on construit un agent que l'on ajoute dans le repertoire
					if (temporaire.isSelected()) {
						statut = "Temporaire";
					}
					else if (permanant.isSelected()) {
						statut = "Permanant";
					}
					else if (stagiaire.isSelected()) {
						statut = "Stagiaire";
					}
					try {
						if((temporaire.isSelected() || permanant.isSelected() || stagiaire.isSelected()) && empty){
							double salaire = Double.parseDouble(salairetext);
							int indice = (int)Integer.parseInt(indicetext);
							Contact agent = new Agent(code, nom, dateDeNaissance, address, email, telNumber ,salaire, statut, categorie, indice, 
									occupation);
							// ajout dans le repertoire
							repertoireCourant.ajouterContact(agent);
							JOptionPane.showMessageDialog(null, "Agent ajouter avec succes !" , "Operation termine", JOptionPane.ERROR_MESSAGE);
							dispose();
								
						}
						else {
							JOptionPane.showMessageDialog(null, "il y'a un champ vide ou mal rempli !" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
						}
					} catch (AgentStatutException e1) {
						JOptionPane.showMessageDialog(null, "statut de l'agent invalide!" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Salaire et indice doivent être des nombres!" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
					}
		
				}
			});
			
		}
		else if (type.toUpperCase().equals("ENSEIGNANT")) {
			// Bouton radion
	        statutLabel = new JLabel("Statut:");
	        statutLabel.setBounds(50, 100, 200, 60);
	        statutLabel.setFont(itemFont);
	        panel.add(statutLabel);
	        
	        temporaire = new JRadioButton("Vacataire");
	        temporaire.setBounds(310, 110, 200, 60);
	        temporaire.setBackground(color);
	        panel.add(temporaire);
	        
	        permanant = new JRadioButton("Permanant");
	        permanant.setBounds(530, 110, 200, 60);
	        permanant.setBackground(color);
	        panel.add(permanant);
	        
	        groupstatut = new ButtonGroup();
	        groupstatut.add(permanant);
	        groupstatut.add(temporaire);
	        
	        // action du bouton d'ajout
	        // configuration de l'action du bouton
	        registerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String statut = "";
					// on construit un agent que l'on ajoute dans le repertoire
					if (temporaire.isSelected()) {
						statut = "Vacataire";
					}
					else if (permanant.isSelected()) {
						statut = "Permanant";
					}
					try {
						if(temporaire.isSelected() || permanant.isSelected()){
							Contact enseignant = new Enseignant(code, nom, dateDeNaissance, address, email, telNumber, statut);
							// ajout dans le repertoire
							repertoireCourant.ajouterContact(enseignant);
							JOptionPane.showMessageDialog(null, "Enseignant ajouter avec succes !" , "Operation termine", JOptionPane.ERROR_MESSAGE);
							dispose();
								
						}
						else {
							JOptionPane.showMessageDialog(null, "il y'a un champ vide ou mal rempli !" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
						}
					} catch (EnseignantStatutException e1) {
						JOptionPane.showMessageDialog(null, "statut de l'agent invalide!" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
						
					}
		
				}
			});
		}
		
		else if (type.toUpperCase().equals("ETUDIANT")) {
			// Bouton radion
	        statutLabel = new JLabel("Cycle:");
	        statutLabel.setBounds(50, 100, 200, 60);
	        statutLabel.setFont(itemFont);
	        panel.add(statutLabel);
	        
	        temporaire = new JRadioButton("Licence");
	        temporaire.setBounds(310, 110, 200, 60);
	        temporaire.setBackground(color);
	        panel.add(temporaire);
	        
	        permanant = new JRadioButton("Ingenieur");
	        permanant.setBounds(530, 110, 200, 60);
	        permanant.setBackground(color);
	        panel.add(permanant);
	        
	        groupstatut = new ButtonGroup();
	        groupstatut.add(permanant);
	        groupstatut.add(temporaire);
	        
	        categorieLabel = new JLabel("Niveau:");
	        categorieLabel.setBounds(50, 170, 200, 60);
	        categorieLabel.setFont(itemFont);
	        panel.add(categorieLabel);
	        
	        categorieField = new JTextField();
	        categorieField.setBounds(310, 170, 600, 60);
	        panel.add(categorieField);
	        
	     // configuration de l'action du bouton
	        registerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String statut = "", niveau;
					niveau = categorieField.getText();
					// on construit un etudiant que l'on ajoute dans le repertoire
					if (temporaire.isSelected()) {
						statut = "License";
					}
					else if (permanant.isSelected()) {
						statut = "Ingenieur";
					}
					try {
						if((temporaire.isSelected() || permanant.isSelected()) && !(niveau.isBlank())){
							Contact etudiant = new Etudiant(code, nom, dateDeNaissance, address, email, telNumber, statut, niveau);
							// ajout dans le repertoire
							repertoireCourant.ajouterContact(etudiant);
							JOptionPane.showMessageDialog(null, "Etudiant ajouter avec succes !" , "Operation termine", JOptionPane.ERROR_MESSAGE);
							dispose();
								
						}
						else {
							JOptionPane.showMessageDialog(null, "il y'a un champ vide ou mal rempli !" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
						}
					} catch (EtudiantCycleException e1) {
						JOptionPane.showMessageDialog(null, "statut de l'agent invalide!" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
						
					}
		
				}
			});
	        
	        
		}
        
        
	}

}
