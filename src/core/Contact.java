package core;

import java.util.Date;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Contact {
	
	private String code;
	private String nom;
	private Date dateDeNaissance;
	private String address;
	private String email;
	private String telNumber;
	
	// constructeur
	public Contact() {
		this.setCode("1234");
		this.setNom("alpha");
		this.dateDeNaissance = new Date();
		this.setAddress("Yaoundé");
		this.setEmail("name@exemple.cm");
		this.setTelNumber("693221031");
	}
	
	public Contact(String code, String nom, String dateDeNaissance, String address, String email, String telNumber) {
		this.setCode(code);
		this.setNom(nom);
		this.setDateDeNaissance(dateDeNaissance);
		this.setAddress(address);
		this.setEmail(email);
		this.setTelNumber(telNumber);
		
	}
	
	// getter et setter

	public String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	protected void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = this.stringtoDate(dateDeNaissance);
	}

	public String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	protected void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	
	// methode de formatage de la date
	public String dateDeNaissanceFormate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormatee = sdf.format(this.getDateDeNaissance());
		return dateFormatee;
	}
	
	// methode qui converti une chaine de caractere en Date
	public Date stringtoDate(String value) {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date dateChoisie = null;
	        try {
	            dateChoisie = sdf.parse(value);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	     return dateChoisie;
	}
	
	// methode d'ajout d'un contact dans la BD
	public abstract int ajouterEnBD(Connection connect);
	

}
