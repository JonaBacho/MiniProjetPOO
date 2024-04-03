/*
 * Created by JFormDesigner on Tue Apr 02 05:18:06 WAT 2024
 */

package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @author jonabacho
 */
public class MainFrmApplication extends TemplateFrm {
	private JLabel label1;
	private JButton button1;
	private JButton button2;
	
	private Connection connect;
	private Repertoire repertoire;
	
	public MainFrmApplication() {
		super("Mon application swing", 1080, 720);
		main();
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
				System.out.println("Echec de l'insertion de : " + contact.toString());
				break;
			}
		}
		
		if (status==0) {
			 System.out.println("Contacts insérées avec succès.");
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


	private void initComponents() {
		
		
		label1 = new JLabel("Application de gestion de contacts");
		label1.setBounds(350,10,800,60);
		label1.setFont(new Font("Arial",Font.BOLD,20));
		panel.add(label1);
		
		
		button1 = new JButton("Creer des contacts");
		button1.setBounds(50, 110, 400, 50);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactFrm contact = new ContactFrm();
				contact.setVisible(true);
			}
		});
		panel.add(button1);
		
		
		
		button2 = new JButton("Afficher des contacts");
		button2.setBounds(650, 110, 400, 50);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactFrmAffichage contact = new ContactFrmAffichage();
				contact.setVisible(true);
			}
		});
		panel.add(button2);
			
		
	}
	
	public static void main(String[] args) {
		
		
		MainFrmApplication main = new MainFrmApplication();
		//MainFrmApplication.creerTable(main.main());
		main.setVisible(true);
	}

	
}
