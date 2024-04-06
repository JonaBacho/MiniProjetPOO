package core;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContactFrmAffichage extends TemplateFrm{
	private JLabel title;
	private JTable tableContact;
	private JScrollPane scroll;
	private JLabel type;
	private JRadioButton typeAgent;
	private JRadioButton typeEnseignant;
	private JRadioButton typeEtudiant;
	private ButtonGroup grouptype;
	
	public ContactFrmAffichage(Connection connect, boolean defaultView) {
		super("Affichage contact de la BD", 1080, 720);
		title = new JLabel("Contacts présent dans la base de données");
		title.setBounds(300,10,800,60);
		title.setFont(titleFont);
		panel.add(title);
		
		
		// allons trifouiller la BD
		try {
			
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
			
            Statement statement = connect.createStatement();

            // Exemple de sélection de toutes les données de la table "utilisateurs"
            String selectDataSQL = "SELECT * FROM Agents";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);
            
            int columnCount = resultSet.getMetaData().getColumnCount();
            
            List<Object[]> dataAgent = new ArrayList<Object[]>();
            List<Object[]> dataEtudiant = new ArrayList<Object[]>();
            List<Object[]> dataEnseignant = new ArrayList<Object[]>();
            
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                dataAgent.add(rowData);
            }
            
            selectDataSQL = "SELECT * FROM Etudiants";
            resultSet = statement.executeQuery(selectDataSQL);
            columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                dataEtudiant.add(rowData);
            }
            
            selectDataSQL = "SELECT * FROM Enseignants";
            resultSet = statement.executeQuery(selectDataSQL);
            columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                dataEnseignant.add(rowData);
            }

         // on definit ici des actions pour les bouttons radio
   		 typeAgent.addActionListener(new ActionListener() {
   	            public void actionPerformed(ActionEvent e) {
   	            	
   	            	// definition des colonnes
   	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone",
   	       		 			"Salaire", "Statut", "Catégorie", "Indice du Salaire", "Occupation"};
   	       		 	// on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
   	            	
   	            	 modelTable.setColumnIdentifiers(Columns);
   	            	 for(Object[] rowData: dataAgent) {
   	            		 modelTable.addRow(rowData);
   	            	 }
   		   			 
   	            }
   	        });
   		 
   		 typeEnseignant.addActionListener(new ActionListener() {
   	            public void actionPerformed(ActionEvent e) {
   	            	 
   	            	// definition des colonnes
   	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone", "Statut"};
   	       		 	// on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
   	            	
   	            	 modelTable.setColumnIdentifiers(Columns);
   	            	 for(Object[] rowData: dataEnseignant) {
   	            		 modelTable.addRow(rowData);
   	            	 }
   		   			 
   	            }
   	        });
   		 
   		 typeEtudiant.addActionListener(new ActionListener() {
   	            public void actionPerformed(ActionEvent e) {
   	            	
   	            	// definition des colonnes
   	       		 	String[] Columns = {"Code", "Nom", "Date de Naissance", "adresse", "Email", "Téléphone", "Cycle", "Niveau"};
   	       		 	// on vide d'abord le tableau des anciennes lignes
	            	 modelTable.setRowCount(0);
   	            	
   	            	modelTable.setColumnIdentifiers(Columns);
   	            	for(Object[] rowData: dataEtudiant) {
  	            		 modelTable.addRow(rowData);
  	            	 }
   	    
   	            }
   	        });
   		 
   		 if(defaultView) typeAgent.doClick();  // on affiche d'abord par defaut les agents

        } catch (SQLException e) {
        	type = new JLabel("Erreur lors du chargement des données depuis la Base de données");
			type.setBounds(50, 80, 800, 60);
			type.setFont(itemFont);
			type.setForeground(new Color(255, 0, 0));
			panel.add(type);
        }
		 
		
	}
	

}
