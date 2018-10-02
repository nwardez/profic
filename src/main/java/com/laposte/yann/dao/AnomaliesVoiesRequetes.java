package com.laposte.yann.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository
public class AnomaliesVoiesRequetes {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	

	@SuppressWarnings("unchecked")
	public List<Object[]> getResultats() {
		 EntityManager session = entityManagerFactory.createEntityManager();
		 
		
		List<Object[]> result = session.createNativeQuery("SELECT  t.TA_TYP, t.TA_LB FROM TYPE_ANO t, PARAM p\r\n" + 
				"        where p.ID_GRP = '52' and p.ID_ITEM > 0 and t.TA_TYP = value\r\n" + 
				"		ORDER BY t.TA_TYP          ASC").getResultList();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAno(String v_insee, String v_ta_typ, String v_coa, String v_actif){
        EntityManager session = entityManagerFactory.createEntityManager();
        try {
           List<Object[]> result = session.createNativeQuery("SELECT  an.ta_typ as ta_typ,\r\n" + 
            		"\r\n" + 
            		"                an.an_dat as an_dat,\r\n" + 
            		"\r\n" + 
            		"                an.an_ins_loc as an_ins_loc,\r\n" + 
            		"\r\n" + 
            		"                an.an_voi as an_voi,\r\n" + 
            		"\r\n" + 
            		"                an.an_cp as an_cp,\r\n" + 
            		"\r\n" + 
            		"                an.an_numero as an_numero,\r\n" + 
            		"\r\n" + 
            		"                an.an_ext as an_ext,\r\n" + 
            		"\r\n" + 
            		"                rn.lb_voie as lb_voie,\r\n" + 
            		"\r\n" + 
            		"                an.an_val_cha as an_val_cha,\r\n" + 
            		"\r\n" + 
            		"                rz.lb_nn as lb_commune,\r\n" + 
            		"\r\n" + 
            		"                ' ' as lb_acheminement,\r\n" + 
            		"\r\n" + 
            		"                an.an_voi_syn as an_voi_syn,\r\n" + 
            		"\r\n" + 
            		"                case when exists (select 1 from E_ANO\r\n" + 
            		"\r\n" + 
            		"                                               where ta_typ = an.ta_typ\r\n" + 
            		"\r\n" + 
            		"                                               AND an_ins_loc = an.an_ins_loc\r\n" + 
            		"\r\n" + 
            		"                                               AND an_voi = an.an_voi\r\n" + 
            		"\r\n" + 
            		"                                               AND an_voi_syn = an.an_voi_syn\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_cp,'') = nvl(an.an_cp,'')\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_numero,'') = nvl(an.an_numero,'')\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_ext,'') = nvl(an.an_ext,'') ) then 1 else 0 end an_actif\r\n" + 
            		"\r\n" + 
            		"FROM ano an, ran_voie rn, ran_adresse ra, ran_za rz\r\n" + 
            		"\r\n" + 
            		"WHERE rz.co_insee = an.an_ins_loc\r\n" + 
            		"\r\n" + 
            		"AND ra.co_cea_voie = rn.co_cea_voie\r\n" + 
            		"\r\n" + 
            		"AND ra.CO_CEA_ZA      = rz.CO_CEA_ZA\r\n" + 
            		"\r\n" + 
            		"AND ra.co_cea_numero is null\r\n" + 
            		"\r\n" + 
            		"AND ra.co_cea_l3 is null\r\n" + 
            		"\r\n" + 
            		"AND an.an_voi = rn.co_voie\r\n" + 
            		"\r\n" + 
            		"AND (an.an_cp = rz.co_postal or rtrim(an.an_cp) is null)\r\n" + 
            		"\r\n" + 
            		"AND (an.an_voi_syn = 0\r\n" + 
            		"\r\n" + 
            		"OR (an.an_voi_syn in (select co_voie_syno from ran_voie_syno where co_voie = rn.co_voie and co_type in (1,2))))\r\n" + 
            		"\r\n" + 
            		"AND ( :v_insee = ' ' or ( :v_insee <> ' ' and rz.co_insee like :v_insee || '%' ) )\r\n" + 
            		"\r\n" + 
            		"AND (an.ta_typ in (SELECT type_ano.ta_typ FROM type_ano, PARAM where id_grp = '52' and id_item > 0 and ta_typ = value))\r\n" + 
            		"\r\n" + 
            		"AND (:v_ta_typ = 0 or an.ta_typ = :v_ta_typ)\r\n" + 
            		"\r\n" + 
            		"AND ( :v_coa = '**' or substr(an.an_ins_loc,1,2) in (select substr(dpt_cod,1,2) from dpt where dpt_coa = :v_coa) )\r\n" + 
            		"\r\n" + 
            		"AND ( (:v_actif = 0) OR (:v_actif =1 and not exists (select 1 from E_ANO\r\n" + 
            		"\r\n" + 
            		"where ta_typ = an.ta_typ\r\n" + 
            		"\r\n" + 
            		"AND an_ins_loc = an.an_ins_loc\r\n" + 
            		"\r\n" + 
            		"AND an_voi = an.an_voi\r\n" + 
            		"\r\n" + 
            		"AND an_voi_syn = an.an_voi_syn\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_cp,'') = nvl(an.an_cp,'')\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_numero,'') = nvl(an.an_numero,'')\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_ext,'') = nvl(an.an_ext,'')) ))\r\n" + 
            		"\r\n" + 
            		"union\r\n" + 
            		"\r\n" + 
            		"  SELECT               an.ta_typ as ta_typ,\r\n" + 
            		"\r\n" + 
            		"                an.an_dat as an_dat,\r\n" + 
            		"\r\n" + 
            		"                an.an_ins_loc as an_ins_loc,\r\n" + 
            		"\r\n" + 
            		"                an.an_voi as an_voi,\r\n" + 
            		"\r\n" + 
            		"                an.an_cp as an_cp,\r\n" + 
            		"\r\n" + 
            		"                an.an_numero as an_numero,\r\n" + 
            		"\r\n" + 
            		"                an.an_ext as an_ext,\r\n" + 
            		"\r\n" + 
            		"                rn.lb_voie as lb_voie,\r\n" + 
            		"\r\n" + 
            		"                an.an_val_cha as an_val_cha,\r\n" + 
            		"\r\n" + 
            		"                rz.lb_nn as lb_commune,\r\n" + 
            		"\r\n" + 
            		"                ' ' as lb_acheminement,\r\n" + 
            		"\r\n" + 
            		"                an.an_voi_syn as an_voi_syn,\r\n" + 
            		"\r\n" + 
            		"                case when exists (select 1 from E_ANO\r\n" + 
            		"\r\n" + 
            		"                                               where ta_typ = an.ta_typ\r\n" + 
            		"\r\n" + 
            		"                                               AND an_ins_loc = an.an_ins_loc\r\n" + 
            		"\r\n" + 
            		"                                               AND an_voi = an.an_voi\r\n" + 
            		"\r\n" + 
            		"                                               AND an_voi_syn = an.an_voi_syn\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_cp,'') = nvl(an.an_cp,'')\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_numero,'') = nvl(an.an_numero,'')\r\n" + 
            		"\r\n" + 
            		"                                               AND nvl(an_ext,'') = nvl(an.an_ext,''))  then 1 else 0 end an_actif\r\n" + 
            		"\r\n" + 
            		"FROM ano an, ran_adresse n,  ran_za rz, ran_voie rn\r\n" + 
            		"\r\n" + 
            		"WHERE (( trim(an.an_val_cha) = n.co_cea_numero and an_voi is  null) )\r\n" + 
            		"\r\n" + 
            		"and rn.co_cea_voie=n.co_cea_voie\r\n" + 
            		"\r\n" + 
            		"AND n.CO_CEA_ZA = rz.CO_CEA_ZA\r\n" + 
            		"\r\n" + 
            		"and rz.co_insee = rn.co_insee\r\n" + 
            		"\r\n" + 
            		"AND (an.an_voi_syn = 0\r\n" + 
            		"\r\n" + 
            		"OR (an.an_voi_syn in (select co_voie_syno from ran_voie_syno where co_voie = rn.co_voie and co_type in (1,2))))\r\n" + 
            		"\r\n" + 
            		"AND ( :v_insee = ' ' or ( :v_insee <> ' ' and rz.co_insee like :v_insee || '%' ) )\r\n" + 
            		"\r\n" + 
            		"AND (an.ta_typ in (SELECT type_ano.ta_typ FROM type_ano, PARAM where id_grp = '52' and id_item > 0 and ta_typ = value))\r\n" + 
            		"\r\n" + 
            		"AND (:v_ta_typ = 0 or an.ta_typ = :v_ta_typ)\r\n" + 
            		"\r\n" + 
            		"AND ( :v_coa = '**' or substr(an.an_ins_loc,1,2) in (select substr(dpt_cod,1,2) from dpt where dpt_coa = :v_coa) )\r\n" + 
            		"\r\n" + 
            		"AND ( (:v_actif = 0) OR (:v_actif =1 and not exists (select 1 from E_ANO\r\n" + 
            		"\r\n" + 
            		"where ta_typ = an.ta_typ\r\n" + 
            		"\r\n" + 
            		"AND an_voi = rn.co_voie\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_cp,'') = nvl(an.an_cp,'')\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_numero,'') = nvl(an.an_numero,'')\r\n" + 
            		"\r\n" + 
            		"AND nvl(an_ext,'') = nvl(an.an_ext,''))))").setParameter("v_insee", v_insee)
            		.setParameter("v_ta_typ", v_ta_typ)
            		.setParameter("v_coa", v_coa)
            		.setParameter("v_actif", v_actif)//.getSingleResult();
            		.getResultList();
        	
 
            return result;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            if(session.isOpen()) session.close();
        }
    }
	  	
	}
	
	 
	
	

	
	
