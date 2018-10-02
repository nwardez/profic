package com.laposte.yann.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.laposte.yann.dao.AnomaliesVoiesRequetes;

import com.laposte.yann.models.LibelleType;

import com.laposte.yann.models.ResultAnoVoie;

@Service
public class AnomaliesVoiesService {
	
	@Autowired
	AnomaliesVoiesRequetes requete;
	
	
public List<LibelleType> findBy52libelle() {
		
		List<Object[]> rows = requete.getResultats();
		List<LibelleType> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new LibelleType((String) row[0].toString(),(String) row[1]));
		}
		return result;
	}

public List<ResultAnoVoie> findResultsAnoVoies(String v_insee, String v_ta_typ,
		String v_coa, String v_actif) {
	
	List<Object[]> rows = requete.getAno(v_insee, v_ta_typ, v_coa, v_actif);
	List<ResultAnoVoie> result = new ArrayList<>(rows.size());
	
	for (Object[] row : rows) {
		Object ligne5 =  row[5];
		if (ligne5 == null) {
			ligne5 = "";
		} else {
			ligne5 = row[5].toString();
		}
	    result.add(new ResultAnoVoie(row[0].toString(),
	    		row[1].toString(),
	    		row[2].toString(),
	    		row[3].toString(),
	    		row[4].toString(),
	    		ligne5.toString(),
	    		row[6].toString(),
	    		row[7].toString(),
	    		row[8].toString(),
	    		row[9].toString(),
	    		row[10].toString(),
	    		row[11].toString(),
	    		row[12].toString()));
	   
	}
	return result;
}






}
