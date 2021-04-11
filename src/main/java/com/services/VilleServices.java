package com.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.config.JDBCConfiguration;
import com.dao.Ville;

public class VilleServices {
	
	private JDBCConfiguration jdbcConfiguration;
	
	private final Map<String,Ville> villes = new HashMap<String,Ville>();
	
	public VilleServices() {
		//super();
		initVilles();
	}

	private void initVilles() {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM ville_france;");
            
            while(resultat.next()) {
            	Ville ville = new Ville(resultat.getInt("Code_commune_INSEE"),resultat.getString("Nom_commune"),
            			resultat.getInt("Code_postal"),resultat.getString("Libelle_acheminement"),
            			resultat.getString("Ligne_5"),resultat.getString("Latitude"),
            			resultat.getString("Longitude"));
            	villes.put(ville.getNomCommune(),ville);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ville> findAll(){
		return villes.values().stream().collect(Collectors.toList());
	}
	
	public Ville findById(final String nom_commune) {
	    return villes.get(nom_commune);
	  }
	  public Ville update(final Ville ville) {
	    villes.put(ville.getNomCommune(), ville);
	    return ville;
	  }
	  public void remove(final String nom_commune) {
	    villes.remove(nom_commune);
	  }
	  public Ville add(final Ville ville) {
	    final Ville newVille = new Ville(ville);
	    villes.put(ville.getNomCommune(), newVille);
	    return newVille;
	  }

}
