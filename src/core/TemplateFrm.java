package core;

import java.awt.Color;

import javax.swing.*;

public class TemplateFrm extends JFrame{
	
	protected JPanel panel;
	
	public TemplateFrm() {
		this.setTitle("Mon application Swing");
		this.setSize(1080,720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// on definit la panel dans laquel tous va se faire
		panel=new JPanel();
		panel.setLayout(null);
		this.add(panel);
		panel.setBackground(new Color(200,250,150));
	}
	
	public TemplateFrm(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// on definit la panel dans laquel tous va se faire
		panel=new JPanel();
		panel.setLayout(null);
		this.add(panel);
		panel.setBackground(new Color(200,250,150));
	}

}
