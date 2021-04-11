package com.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.JDBCConfiguration;
import com.dao.Ville;
import com.dao.VilleDao;

@RestController
public class VilleController {
	
	@ResponseBody
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	public List<Ville> appelGet() throws JSONException {
		System.out.println("Appel GET");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.afficheVilles();
	}
	
	@ResponseBody
	@RequestMapping(value = "/codeINSEE", method = RequestMethod.GET)
	public Ville appelGet(@RequestParam("id") String cp) {
		System.out.println("Appel GET cp");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    return villeDao.chercheVillesCP(cp);
	}
	
	@ResponseBody
	@RequestMapping(value = "/code_postal", method = RequestMethod.DELETE)
	public String appelDelete(@RequestParam("id") String cp) {
		System.out.println("Appel Delete");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.supprimeVillesCP(cp);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String appelUpdate(@RequestParam("commune") String commune,
			@RequestParam("codeInsee")String codeInsee,
			@RequestParam("cp") String cp,
			@RequestParam("libelle") String libelle,
			@RequestParam("ligne5") String ligne5,
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude
			) {
		System.out.println("Appel Post");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.insertVille(commune,codeInsee,cp,libelle,ligne5,longitude,latitude);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String appelPost(@RequestParam("commune") String commune,
			@RequestParam("codeInsee")String codeInsee,
			@RequestParam("cp") String cp,
			@RequestParam("libelle") String libelle,
			@RequestParam("ligne5") String ligne5,
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude
			) {
		System.out.println("Appel Update");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.updateVille(commune,codeInsee,cp,libelle,ligne5,longitude,latitude);
	}
}
