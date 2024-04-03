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
	
	public ContactFrmFinal(String type) {
		super("creation d'un nouvel " + type, 1080, 720);
		// Initialisation des composants
		title = new JLabel("Finalisation de la creation de l'" + type);
		title.setBounds(350, 10 , 800, 60);
		title.setFont(new Font("Arial",Font.BOLD,20));
		
        salaireLabel = new JLabel("Salaire:");
        salaireLabel.setBounds(50, 100, 200, 60);
        salaireLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        categorieLabel = new JLabel("Categorie:");
        categorieLabel.setBounds(50, 170, 200, 60);
        categorieLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        indiceLabel = new JLabel("Indice de salaire");
        indiceLabel.setBounds(50, 240, 200, 60);
        indiceLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        occupationLabel = new JLabel("Occupation:");
        occupationLabel.setBounds(50, 310, 200, 60);
        occupationLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        
        salaireField = new JTextField();
        salaireField.setBounds(310, 100, 600, 60);
        
        categorieField = new JTextField();
        categorieField.setBounds(310, 170, 600, 60);
        
        indiceField = new JTextField();
        indiceField.setBounds(310, 240, 600, 60);
        
        occupationField = new JTextField();
        occupationField.setBounds(310, 310, 600, 60);
        
        // Bouton radion
        statutLabel = new JLabel("Statut:");
        statutLabel.setBounds(50, 380, 200, 60);
        statutLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        temporaire = new JRadioButton("Temporaire");
        temporaire.setBounds(310, 380, 200, 60);
        temporaire.setBackground(new Color(200,250,150));
        
        stagiaire = new JRadioButton("Stagiaire");
        stagiaire.setBounds(530, 380, 200, 60);
        stagiaire.setBackground(new Color(200,250,150));
        
        permanant = new JRadioButton("Permanant");
        permanant.setBounds(750, 380, 200, 60);
        permanant.setBackground(new Color(200,250,150));
        
        groupstatut = new ButtonGroup();
        groupstatut.add(permanant);
        groupstatut.add(stagiaire);
        groupstatut.add(temporaire);
        
        registerButton = new JButton("Enregistrer");
        registerButton.setBounds(450, 600, 200, 30);
        // configuration de l'action du bouton
        registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String salaire, categorie, indice, occupation, statut;
				salaire = salaireField.getText();
				categorie = categorieField.getText();
				indice = indiceField.getText();
				occupation = occupationField.getText();
				boolean empty = !(salaire.isBlank()) && !(categorie.isBlank()) && !(indice.isBlank()) && !(occupation.isBlank());
				if(temporaire.isSelected() && empty){
					statut = "Temporaire";
					dispose();	
				}
				else if(permanant.isSelected() && empty) {
					statut = "Permanant";
					dispose();
				}
				else if(stagiaire.isSelected() && empty) {
					statut = "Stagiaire";
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "il y'a un champ vide ou mal rempli !" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        
        
	}

}
