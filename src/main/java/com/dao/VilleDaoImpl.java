package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.JDBCConfiguration;
import  java.sql.Connection;
import java.sql.PreparedStatement;
import  java.sql.Statement;

public class VilleDaoImpl implements VilleDao {

	private JDBCConfiguration jdbcConfiguration;

	public VilleDaoImpl(JDBCConfiguration jdbcConfiguration) {
		this.jdbcConfiguration = jdbcConfiguration;
	}

	@Override
	public List<Ville> afficheVilles() {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		List<Ville> villes = new ArrayList<Ville>();
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france;");

			while(resultat.next()) {
				Ville ville = new Ville(resultat.getInt("Code_commune_INSEE"),resultat.getString("Nom_commune"),
						resultat.getInt("Code_postal"),resultat.getString("Libelle_acheminement"),
						resultat.getString("Ligne_5"),resultat.getString("Latitude"),
						resultat.getString("Longitude"));
				villes.add(ville);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return villes;

	}

	public Ville chercheVillesCP(String cp) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		Ville ville = new Ville();
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france WHERE Code_commune_INSEE = "+cp+";");
			resultat.next();
			ville.setNomCommune(resultat.getString("Nom_commune"));
			ville.setCodeINSEE(Integer.parseInt(resultat.getString("Code_commune_INSEE")));
			ville.setCP(Integer.parseInt(resultat.getString("Code_postal")));
			ville.setLattitude(resultat.getString("Latitude"));
			ville.setLibelleAcheminement(resultat.getString("Libelle_acheminement"));
			ville.setLigne_5(resultat.getString("Ligne_5"));
			ville.setLongitude(resultat.getString("Longitude"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;

	}

	@Override
	public String supprimeVillesCP(String cp) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String query = "DELETE FROM ville_france WHERE Code_commune_INSEE ="+cp+" ;";
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
			statement.executeUpdate(query);
			//resultat = statement.executeQuery("DELETE FROM ville_france WHERE Code_commune_INSEE ="+cp+" ;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Ville supprimé";
	}

	@Override
	public String insertVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String query = "INSERT INTO ville_france "
				+ "(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) "
				+ "VALUES"
				+"(\"" + codeInsee +"\",\""
				+ commune +"\",\""
				+ cp +"\",\""
				+ libelle +"\",\""
				+ ligne5 +"\",\""
				+ longitude +"\",\""
				+ latitude +"\");";
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
			statement.executeUpdate(query);
			//resultat = statement.executeQuery("DELETE FROM ville_france WHERE Code_commune_INSEE ="+cp+" ;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Ville inséré";
	}

	@Override
	public String updateVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String query = "UPDATE ville_france "
				+ "SET `Code_commune_INSEE` = \""+codeInsee+"\""
				+ ",`Nom_commune` = \""+commune+"\""
				+ ",`Code_postal` = \""+cp+"\""
				+ ",`Libelle_acheminement` = \""+libelle+"\""
				+ ",`Ligne_5` = \""+ligne5+"\""
				+ ",`Latitude` = \""+longitude+"\""
				+ ",`Longitude` = \""+latitude+"\""
				+ " WHERE Code_commune_INSEE = \""+codeInsee+"\";";
		System.out.println(query);
		try {
			connexion = jdbcConfiguration.getConnection();
			statement = connexion.createStatement();
			statement.executeUpdate(query);
			//resultat = statement.executeQuery("DELETE FROM ville_france WHERE Code_commune_INSEE ="+cp+" ;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Ville mise à jour";
	}

}
