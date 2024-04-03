package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ContactFrm extends TemplateFrm{
	
	private JLabel title;
	private JLabel codeLabel;
	private JLabel nomLabel;
	private JLabel dateDeNaissanceLabel;
	private JLabel adressLabel;
	private JLabel emailLabel;
	private JLabel telNumberLabel;
	private JLabel type;
	private JRadioButton typeAgent;
	private JRadioButton typeEnseignant;
	private JRadioButton typeEtudiant;
	private ButtonGroup grouptype;
	
	private JTextField codeField;
	private JTextField nomField;
	private JTextField dateDeNaissanceField;
	private JTextField adressField;
	private JTextField emailField;
	private JTextField telNumberField;
	
	private JButton nextButton;
	
	public ContactFrm() {
		super("Creer un nouveau contact", 1080, 720);
		// Initialisation des composants
		title = new JLabel("Formulaire d'enregistrement d'un contact");
		title.setBounds(350,10,800,60);
		title.setFont(new Font("Arial",Font.BOLD,20));
		
        codeLabel = new JLabel("Code:");
        codeLabel.setBounds(50, 100, 200, 60);
        codeLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        nomLabel = new JLabel("Nom:");
        nomLabel.setBounds(50, 170, 200, 60);
        nomLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        dateDeNaissanceLabel = new JLabel("Date de Naissance:");
        dateDeNaissanceLabel.setBounds(50, 240, 200, 60);
        dateDeNaissanceLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 310, 200, 60);
        emailLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        telNumberLabel = new JLabel("Telephone:");
        telNumberLabel.setBounds(50, 380, 200, 60);
        telNumberLabel.setFont(new Font("Arial",Font.BOLD,15));
        
        adressLabel = new JLabel("Addresse:");
        adressLabel.setBounds(50, 450, 200, 60);
        adressLabel.setFont(new Font("Arial",Font.BOLD,15));
        
     
        codeField = new JTextField();
        codeField.setBounds(310, 100, 600, 60);
        
        nomField = new JTextField();
        nomField.setBounds(310, 170, 600, 60);
        
        dateDeNaissanceField = new JTextField();
        dateDeNaissanceField.setBounds(310, 240, 600, 60);
        
        emailField = new JTextField();
        emailField.setBounds(310, 310, 600, 60);
        
        telNumberField = new JTextField();
        telNumberField.setBounds(310, 380, 600, 60);
        
        adressField = new JTextField();
        adressField.setBounds(310, 450, 600, 60);
        
        
        // Bouton Radio
        type = new JLabel("Type contact:");
		type.setBounds(50, 520, 200, 60);
		type.setFont(new Font("Arial",Font.BOLD,15));
		//type.setForeground(Color.white);
		
		typeAgent = new JRadioButton("Agent");
		typeAgent.setBounds(310, 530, 200, 30);
		typeAgent.setBackground(new Color(200,250,150));
		
		typeEtudiant = new JRadioButton("Etudiant");
		typeEtudiant.setBounds(530, 530, 200, 30);
		typeEtudiant.setBackground(new Color(200,250,150));
		
		typeEnseignant = new JRadioButton("Enseignant");
		typeEnseignant.setBounds(750, 530, 200, 30);
		typeEnseignant.setBackground(new Color(200,250,150));
		
		grouptype = new ButtonGroup();
		grouptype.add(typeAgent);
		grouptype.add(typeEtudiant);
		grouptype.add(typeEnseignant);
		
		nextButton = new JButton("Continuer");
        nextButton.setBounds(450, 600, 200, 30);
        // configuration de l'action du bouton
        nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String code, nom, dateDeNaissance, email, telNumber, adress;
				code = codeField.getText();
				nom = nomField.getText();
				dateDeNaissance = dateDeNaissanceField.getText();
				email = emailField.getText();
				telNumber = telNumberField.getText();
				adress = adressField.getText();
				
				boolean empty = !(code.isBlank()) && !(nom.isBlank()) && !(dateDeNaissance.isBlank()) && !(email.isBlank()) && !(telNumber.isBlank()) 
						&& !(adress.isBlank());
				if(typeAgent.isSelected() && empty){
					// finaliser la creation
					dispose();	
				}
				else if(typeEtudiant.isSelected() && empty) {
					// finaliser la creation
					dispose();
				}
				else if(typeEnseignant.isSelected() && empty) {
					// finaliser la creation
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "il y'a un champ vide !" , "Erreur sur Formulaire", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
        // Ajout des composants à la fenêtre
        panel.add(title);
        panel.add(codeLabel);
        panel.add(nomLabel);
        panel.add(dateDeNaissanceLabel);
        panel.add(emailLabel);
        panel.add(telNumberLabel);
        panel.add(adressLabel);
        panel.add(type);
        
        panel.add(codeField);
        panel.add(nomField);
        panel.add(dateDeNaissanceField);
        panel.add(emailField);
        panel.add(telNumberField);
        panel.add(adressField);
        panel.add(typeAgent);
        panel.add(typeEtudiant);
        panel.add(typeEnseignant);
        
        panel.add(nextButton);
	}

}
