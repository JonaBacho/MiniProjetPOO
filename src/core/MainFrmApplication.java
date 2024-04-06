/*
 * Created by JFormDesigner on Tue Apr 02 05:18:06 WAT 2024
 */

package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 * @author jonabacho
 */
public class MainFrmApplication extends TemplateFrm {
	private Repertoire repertoire;
	
	private JLabel label1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	
	private Connection connect;
	
	public MainFrmApplication() {
		super("Mon application swing", 1080, 720);
		repertoire = new Repertoire();
		connect = main();
		initComponents();
	}
	
	public Connection main() {
		String url = "jdbc:mysql://localhost:3306/JAVATEST";
        String utilisateur = "jonabacho";
        String motDePasse = "jonabacho";

        try {
            // Chargement du pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etablissement de la connexion
            connect = DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
	}
	
	// methode pour enregistrer les contacts de l'attribut repertoire en BD
	public int enregistrer() {
		int status=1;
		
		for(Contact contact: repertoire.getContacts()) {
			
			// ajout du contact en BD
			status = contact.ajouterEnBD(connect);
			if (status==-1) {
				break;
			}
		}
		return status;
	}
	
	
	private static void creerTable(Connection connexion) {
        try {
            Statement statement = connexion.createStatement();

            // création d'une table "Agents"
            String createTableSQL = "CREATE TABLE Agents " +
                    "(code VARCHAR(255) PRIMARY KEY, " + "nom VARCHAR(255), " + "dateDeNaissance Date, " +
                    "address VARCHAR(255), " + "email VARCHAR(255), " + "telNumber VARCHAR(255), " +
                    "salaire DECIMAL(9, 2), " + "statut VARCHAR(255), " + "categorie VARCHAR(255), " +
                    "indice INTEGER(4), " + "occupation VARCHAR(255))";
            statement.executeUpdate(createTableSQL);
            
            // création d'une table "Etudiant"
            createTableSQL = "CREATE TABLE Etudiants " + "(code VARCHAR(255) PRIMARY KEY, " + "nom VARCHAR(255), " + "dateDeNaissance Date, " +
                    "address VARCHAR(255), " + "email VARCHAR(255), " + "telNumber VARCHAR(255), " + " cycle VARCHAR(255), " + "niveau VARCHAR(255))";
            statement.executeUpdate(createTableSQL);
            
            // creation d'une table Enseignant
            createTableSQL = " CREATE TABLE Enseignants " + "(code VARCHAR(255) PRIMARY KEY, " + "nom VARCHAR(255), " + "dateDeNaissance Date, " +
                    "address VARCHAR(255), " + "email VARCHAR(255), " + "telNumber VARCHAR(255), " + " satut VARCHAR(255))";
            statement.executeUpdate(createTableSQL);

            System.out.println("Tables créée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private static void renameColumn(Connection connect) {
		// La requête SQL pour modifier le nom de la colonne
        String nomTable = "Etudiants";
        String ancienNomColonne = "satut";
        String nouveauNomColonne = "statut";
        String sql = "ALTER TABLE " + nomTable + " CHANGE COLUMN " + ancienNomColonne + " " + nouveauNomColonne + " VARCHAR(255)";
        /*
        Statement statement;
		try {
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("La colonne a été renommée avec succès.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
            DatabaseMetaData metaData = connect.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, nomTable, null);

            System.out.println("Noms des colonnes de la table " + nomTable + ":");
            while (resultSet.next()) {
                String nomColonne = resultSet.getString("COLUMN_NAME");
                System.out.println(nomColonne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
	}

	private void initComponents() {
		// Créer la barre de menu
        JMenuBar menuBar = new JMenuBar();
        
        // Créer les menus
        JMenu fileMenu = new JMenu("Fichier");
        JMenu editMenu = new JMenu("Edition");
        JMenu helpMenu = new JMenu("Aide");
        
        // Créer les éléments de menu
        JMenuItem saveMenuItem = new JMenuItem("Enregistrer");
        JMenuItem exitMenuItem = new JMenuItem("Quitter");
        
        // Ajouter des écouteurs d'événements aux éléments de menu
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                System.exit(0); // Quitter l'application
            }
        });
        
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// on enregistre tous les contacts du repertoire courant
            	int status = enregistrer();
            	if (status == -1) {
            		JOptionPane.showMessageDialog(null, "Erreur survenu !" , "Remplissage du repertoire", JOptionPane.ERROR_MESSAGE);
            	}
            	else if (status == 1){
            		JOptionPane.showMessageDialog(null, "Reprtoire vide !" , "Remplissage du repertoire", JOptionPane.ERROR_MESSAGE);
            	}
            	else if (status == 0) {
            		JOptionPane.showMessageDialog(null, "Operation réussi !" , "Remplissage du repertoire", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        
        // Ajouter les éléments de menu aux menus
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator(); // Ajouter une ligne de séparation
        fileMenu.add(exitMenuItem);
        
        // Ajouter les menus à la barre de menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        
        // Ajouter la barre de menu à la JFrame
        setJMenuBar(menuBar);
        
		label1 = new JLabel("Application de gestion de contacts");
		label1.setBounds(350,10,800,60);
		label1.setFont(titleFont);
		panel.add(label1);
		
		
		button1 = new JButton("Creer des contacts");
		button1.setBounds(100, 110, 250, 50);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactFrm contact = new ContactFrm(repertoire);
				contact.setVisible(true);
			}
		});
		panel.add(button1);
		
		
		button2 = new JButton("Afficher des contacts");
		button2.setBounds(400, 110, 250, 50);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactFrmAffichage contact = new ContactFrmAffichage(connect, true);
				contact.setVisible(true);
			}
		});
		panel.add(button2);
		
		
		button3 = new JButton("voir contenu repertoire");
		button3.setBounds(700, 110, 250, 50);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 RepertoireFrm repertoireView = new RepertoireFrm(repertoire, true);
				 repertoireView.setVisible(true);
			}
		});
		panel.add(button3);
			
		
	}
	
	public static void main(String[] args) {
		
		
		MainFrmApplication mainV = new MainFrmApplication();
		//MainFrmApplication.renameColumn(mainV.main());
		//MainFrmApplication.creerTable(main.main());
		mainV.setVisible(true);
	}

	
}
