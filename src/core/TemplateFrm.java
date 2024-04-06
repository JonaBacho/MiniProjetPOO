package core;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class TemplateFrm extends JFrame{
	
	protected JPanel panel;
	protected Color color = new Color(200,250,150);
	protected Font titleFont = new Font("Arial",Font.BOLD,20);
	protected Font itemFont = new Font("Arial",Font.BOLD,15);
	
	public TemplateFrm() {
		this.setTitle("Mon application Swing");
		this.setSize(1080,720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// on definit la panel dans laquel tous va se faire
		panel=new JPanel();
		panel.setLayout(null);
		this.add(panel);
		panel.setBackground(color);
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
		panel.setBackground(color);
	}

}
