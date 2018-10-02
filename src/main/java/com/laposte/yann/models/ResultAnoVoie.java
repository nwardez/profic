package com.laposte.yann.models;



public class ResultAnoVoie {
	
	
	private String ta_typ; // Numéro anomalie
	private String an_date; // Date Importation
	private String an_ins_loc; //Code INSEE
	private String an_voi; // Matricule Voie
	private String an_cp; // Code Postal
	private String an_numero;// Numero dans la voie
	private String an_ext; // Extension
	private String lb_voie; // Libellé Voie
	private String an_val_char; // Divers
	private String lb_commune; // Libelle Commune
	private String lb_achemeinement; // Libelle acheminement
	private String an_voi_syn; // Masquage
	private String an_actif;
	
	
	
	
	
	
	public ResultAnoVoie() {
		super();
	}




	



	public ResultAnoVoie(String ta_typ, String an_date, String an_ins_loc, String an_voi, String an_cp, String an_numero,
			String an_ext, String lb_voie, String an_val_char, String lb_commune, String lb_achemeinement,
			String an_voi_syn, String an_actif) {
		super();
		this.ta_typ = ta_typ;
		this.an_date = an_date;
		this.an_ins_loc = an_ins_loc;
		this.an_voi = an_voi;
		this.an_cp = an_cp;
		this.an_numero = an_numero;
		this.an_ext = an_ext;
		this.lb_voie = lb_voie;
		this.an_val_char = an_val_char;
		this.lb_commune = lb_commune;
		this.lb_achemeinement = lb_achemeinement;
		this.an_voi_syn = an_voi_syn;
		this.an_actif = an_actif;
	}








	public String getAn_actif() {
		return an_actif;
	}








	public void setAn_actif(String an_actif) {
		this.an_actif = an_actif;
	}








	public String getTa_typ() {
		return ta_typ;
	}




	public void setTa_typ(String ta_typ) {
		this.ta_typ = ta_typ;
	}




	public String getAn_date() {
		return an_date;
	}




	public void setAn_date(String an_date) {
		this.an_date = an_date;
	}




	public String getAn_ins_loc() {
		return an_ins_loc;
	}




	public void setAn_ins_loc(String an_ins_loc) {
		this.an_ins_loc = an_ins_loc;
	}




	public String getLb_commune() {
		return lb_commune;
	}




	public void setLb_commune(String lb_commune) {
		this.lb_commune = lb_commune;
	}




	public String getAn_voi() {
		return an_voi;
	}




	public void setAn_voi(String an_voi) {
		this.an_voi = an_voi;
	}




	public String getAn_cp() {
		return an_cp;
	}




	public void setAn_cp(String an_cp) {
		this.an_cp = an_cp;
	}




	public String getLb_voie() {
		return lb_voie;
	}




	public void setLb_voie(String lb_voie) {
		this.lb_voie = lb_voie;
	}








	public String getAn_numero() {
		return an_numero;
	}








	public void setAn_numero(String an_numero) {
		this.an_numero = an_numero;
	}








	public String getAn_ext() {
		return an_ext;
	}








	public void setAn_ext(String an_ext) {
		this.an_ext = an_ext;
	}








	public String getAn_val_char() {
		return an_val_char;
	}








	public void setAn_val_char(String an_val_char) {
		this.an_val_char = an_val_char;
	}








	public String getLb_achemeinement() {
		return lb_achemeinement;
	}








	public void setLb_achemeinement(String lb_achemeinement) {
		this.lb_achemeinement = lb_achemeinement;
	}








	public String getAn_voi_syn() {
		return an_voi_syn;
	}








	public void setAn_voi_syn(String an_voi_syn) {
		this.an_voi_syn = an_voi_syn;
	}
	
	
	
	

}
