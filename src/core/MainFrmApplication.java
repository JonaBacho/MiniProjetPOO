/*
 * Created by JFormDesigner on Tue Apr 02 05:18:06 WAT 2024
 */

package core;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;


/**
 * @author jonabacho
 */
public class MainFrmApplication extends JFrame {
	
	private Connection connect;
	
	public MainFrmApplication() {
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
	
	private static void creerTable(Connection connexion) {
        try {
            Statement statement = connexion.createStatement();

            // Exemple de création d'une table "utilisateurs"
            String createTableSQL = "CREATE TABLE Agents " +
                    "(id INTEGER(6) PRIMARY KEY AUTO_INCREMENT, " +
                    "code VARCHAR(255), " + "nom VARCHAR(255), " + "dateDeNaissance Date, " +
                    "address VARCHAR(255), " + "email VARCHAR(255), " + "telNumber VARCHAR(255), " +
                    "salaire DECIMAL(9, 2), " + "statut VARCHAR(255), " + "categorie VARCHAR(255), " +
                    "indice INTEGER(4), " + "occupation VARCHAR(255), " +
                    "age INT)" + "\n ENGINE=INNODB;";
            
            statement.executeUpdate(createTableSQL);

            System.out.println("Table créée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private void AfficheContact(ActionEvent e) {
		// TODO add your code here
	}

	private void AjoutContact(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Jonathan Bachelard
		label1 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("GESTION DE CONTACT");
		contentPane.add(label1, "cell 7 0");

		//---- button1 ----
		button1.setText("Afficher les contacts");
		button1.addActionListener(e -> AfficheContact(e));
		contentPane.add(button1, "cell 5 4");

		//---- button2 ----
		button2.setText("Ajouter un contact");
		button2.addActionListener(e -> AjoutContact(e));
		contentPane.add(button2, "cell 9 4");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Jonathan Bachelard
	private JLabel label1;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
