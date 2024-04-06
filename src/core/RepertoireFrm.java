package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RepertoireFrm extends TemplateFrm{
	
	private JLabel title;
	private JTable tableContact;
	private JScrollPane scroll;
	private JLabel type;
	private JRadioButton typeAgent;
	private JRadioButton typeEnseignant;
	private JRadioButton typeEtudiant;
	private ButtonGroup grouptype;
	
	public RepertoireFrm(Repertoire repertoireCourant, boolean defaultView) {
		super("Repertoire courant", 1080, 720);
		title = new JLabel("Contacts présent dans le repertoire courant");
		title.setBounds(300,10,800,60);
		title.setFont(titleFont);
		panel.add(title);
		
		// Bouton Radio
        type = new JLabel("Type contact:");
		type.setBounds(50, 80, 200, 60);
		type.setFont(itemFont);
		panel.add(type);
		//type.setForeground(Color.white);
		
		typeAgent = new JRadioButton("Agent");
		typeAgent.setBounds(310, 90, 200, 30);
		typeAgent.setBackground(color);
		panel.add(typeAgent);
		
		typeEtudiant = new JRadioButton("Etudiant");
		typeEtudiant.setBounds(530, 90, 200, 30);
		typeEtudiant.setBackground(color);
		panel.add(typeEtudiant);
		
		typeEnseignant = new JRadioButton("Enseignant");
		typeEnseignant.setBounds(750, 90, 200, 30);
		typeEnseignant.setBackground(color);
		panel.add(typeEnseignant);
		
		grouptype = new ButtonGroup();
		grouptype.add(typeAgent);
		grouptype.add(typeEtudiant);
		grouptype.add(typeEnseignant);
		
		DefaultTableModel modelTable = new DefaultTableModel();
		 tableContact = new JTable();
		 scroll = new JScrollPane();
		 panel.add(scroll);
		 scroll.setBounds(50, 160, 950, 160);
		 scroll.setViewportView(tableContact);
		 
		 
		 tableContact.setModel(modelTable);
		 
		 // on definit ici des actions pour les bouttons radio
		 typeAgent.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	// definition des colonnes
	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone",
	       		 			"Salaire", "Statut", "Catégorie", "Indice du Salaire", "Occupation"};
	            	
	            	 modelTable.setColumnIdentifiers(Columns);
	            	 
	            	 // on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
		   			 
		   			 for(Contact contact: repertoireCourant.getContacts()) {
		   				 if(contact instanceof Agent) {
		   					 modelTable.addRow(new Object[] {
		   							 contact.getCode(), contact.getNom(), contact.dateDeNaissanceFormate(), contact.getAddress(),
		   							 contact.getEmail(), contact.getTelNumber(), ((Agent) contact).getSalaire(), ((Agent) contact).getStatut(),
		   							 ((Agent) contact).getCategorie(), ((Agent) contact).getIndiceDeSalaire(), ((Agent) contact).getOccupation()
		   					 });
		   				 }
		   			 }
	            }
	        });
		 
		 typeEnseignant.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 
	            	// definition des colonnes
	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone", "Statut"};
	            	
	            	 modelTable.setColumnIdentifiers(Columns);
	            	// on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
	   			 
		   			 for(Contact contact: repertoireCourant.getContacts()) {
		   				 if(contact instanceof Enseignant) {
		   					 modelTable.addRow(new Object[] {
		   							 contact.getCode(), contact.getNom(), contact.dateDeNaissanceFormate(), contact.getAddress(),
		   							 contact.getEmail(), contact.getTelNumber(), ((Enseignant) contact).getStatut()
		   					 });
		   			 
		   				 }
		   			  }
	            }
	        });
		 
		 typeEtudiant.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	// definition des colonnes
	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone", "Cycle", "Niveau"};
	            	
	            	 modelTable.setColumnIdentifiers(Columns);
	            	// on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
	    			 
	    			for(Contact contact: repertoireCourant.getContacts()) {
	    				if(contact instanceof Etudiant) {
	    					modelTable.addRow(new Object[] {
	    							contact.getCode(), contact.getNom(), contact.dateDeNaissanceFormate(), contact.getAddress(),
	    							contact.getEmail(), contact.getTelNumber(), ((Etudiant) contact).getCycle(), ((Etudiant) contact).getNiveau()
	    					});
	    				}
	    			}
	            }
	        });
		 
		 if(defaultView) typeAgent.doClick();  // on affiche d'abord par defaut les agents
	}

}
