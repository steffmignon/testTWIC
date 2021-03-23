package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.JDBCConfiguration;
import com.dao.VilleDao;

@RestController
public class VilleController {
	
	@ResponseBody
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	public String appelGet() {
		System.out.println("Appel GET");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.afficheVilles();
	}
	
	@ResponseBody
	@RequestMapping(value = "/code_postal", method = RequestMethod.GET)
	public String appelGet(@RequestParam String cp) {
		System.out.println("Appel GET");
		
		VilleDao villeDao;
		JDBCConfiguration jdbcConfiguration = JDBCConfiguration.getInstance();
	    villeDao = jdbcConfiguration.getVilleDao();
	    
	    return villeDao.chercheVillesCP(cp);
	}
}
