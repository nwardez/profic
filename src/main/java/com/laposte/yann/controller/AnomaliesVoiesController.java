package com.laposte.yann.controller;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.laposte.yann.models.LibelleType;
import com.laposte.yann.models.ResultAnoVoie;
import com.laposte.yann.service.AnomaliesVoiesService;



@CrossOrigin("*")
@RestController
public class AnomaliesVoiesController {


	
	@Autowired
	private AnomaliesVoiesService daoService;

	

	/**
	 * JSON
	 * @param v_insee
	 * @param v_ta_typ
	 * @param v_coa
	 * @param v_actif
	 * Retourne la liste des anomalies voies avec les paramètres en entrée
	 */
	@RequestMapping( value="listanobis", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<ResultAnoVoie> findResultAnoVoie(@RequestParam(value = "v_insee", required = true) String v_insee, 
			@RequestParam(value = "v_ta_typ", required = false) String v_ta_typ,
			@RequestParam(value = "v_coa", required = false) String v_coa,
			@RequestParam(value = "v_actif", required = false) String v_actif){
		return  daoService.findResultsAnoVoies(v_insee,v_ta_typ,v_coa,v_actif);

	}



	/**
	 * JSON
	 * @Retourne la liste des anomalies de catégorie Voie
	 * PROFIC 98
	 */
	@RequestMapping( value="listAnosVoies", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE  )
	public List<LibelleType> listAnosLibelle() {
		return  daoService.findBy52libelle();
	}




}
