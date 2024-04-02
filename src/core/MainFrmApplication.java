/*
 * Created by JFormDesigner on Tue Apr 02 05:18:06 WAT 2024
 */

package core;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author jonabacho
 */
public class MainFrmApplication extends JFrame {
	public MainFrmApplication() {
		initComponents();
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
