package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.JDBCConfiguration;
import com.dao.Ville;
import com.dao.VilleDao;

@RestController
public class VilleController {
	
	@ResponseBody
	@GetMapping(path = "/ville")
	public List<Ville> appelGet() throws JSONException, SQLException {
		System.out.println("Appel GET");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.afficheVilles();
	}
	
	@ResponseBody
	@GetMapping(path = "/codeINSEE")
	public Ville appelGet(@RequestParam("id") String cp) throws SQLException {
		System.out.println("Appel GET cp");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    return villeDao.chercheVillesCP(cp);
	}
	
	@ResponseBody
	@DeleteMapping(path = "/code_postal")
	public String appelDelete(@RequestParam("id") String cp) throws SQLException {
		System.out.println("Appel Delete");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.supprimeVillesCP(cp);
	}
	
	
	@ResponseBody
	@PostMapping(path = "/insert")
	public String appelUpdate(@RequestParam("commune") String commune,
			@RequestParam("codeInsee")String codeInsee,
			@RequestParam("cp") String cp,
			@RequestParam("libelle") String libelle,
			@RequestParam("ligne5") String ligne5,
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude
			) throws SQLException {
		System.out.println("Appel Post");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.insertVille(commune,codeInsee,cp,libelle,ligne5,longitude,latitude);
	}
	
	@ResponseBody
	@PutMapping(path = "/update")
	public String appelPost(@RequestParam("commune") String commune,
			@RequestParam("codeInsee")String codeInsee,
			@RequestParam("cp") String cp,
			@RequestParam("libelle") String libelle,
			@RequestParam("ligne5") String ligne5,
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude
			) throws SQLException {
		System.out.println("Appel Update");

		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.updateVille(commune,codeInsee,cp,libelle,ligne5,longitude,latitude);
	}
}
