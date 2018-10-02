package com.laposte.yann.models;


public class LibelleType {
	
	private String type;
	private String libelle;
	
	
	public LibelleType(String type, String libelle) {
		super();
		this.type = type;
		this.libelle = libelle;
	}


	public LibelleType() {
		super();
	}



	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
	
	

}
