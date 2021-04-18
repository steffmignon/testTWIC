package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Application;
import com.config.JDBCConfiguration;

public class VilleDaoImpl implements VilleDao {

	private JDBCConfiguration jdbcConfiguration;


	public VilleDaoImpl(JDBCConfiguration jdbcConfiguration) {
		this.jdbcConfiguration = jdbcConfiguration;
	}

	@Override
	public List<Ville> afficheVilles() throws SQLException {
		Connection connexion = null;

		Statement statement = null;
		ResultSet resultat = null;
		List<Ville> villes = new ArrayList<>();
		connexion = jdbcConfiguration.getConnection();

		try {
			statement = connexion.createStatement();

			resultat = statement.executeQuery("SELECT * FROM ville_france;");
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getInt("Code_commune_INSEE"), resultat.getString("Nom_commune"),
						resultat.getInt("Code_postal"), resultat.getString("Libelle_acheminement"),
						resultat.getString("Ligne_5"), resultat.getString("Latitude"), resultat.getString("Longitude"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, "contexte", e);
		} finally {
		}

		return villes;

	}

	public Ville chercheVillesCP(String cp) throws SQLException {
		Connection connexion = null;
		java.sql.PreparedStatement pstmt = null;
		String query = "SELECT * FROM ville_france WHERE Code_commune_INSEE = ?;";
		ResultSet resultat = null;
		Ville ville = new Ville();
		connexion = jdbcConfiguration.getConnection();

		try {
			pstmt = connexion.prepareStatement(query);
			pstmt.setString(1, cp);

			resultat = pstmt.executeQuery();
			if (resultat.first()) {
				if (resultat.getString("Nom_commune") != null) {
					ville.setNomCommune(resultat.getString("Nom_commune"));
					ville.setCodeINSEE(Integer.parseInt(resultat.getString("Code_commune_INSEE")));
					ville.setCP(Integer.parseInt(resultat.getString("Code_postal")));
					ville.setLattitude(resultat.getString("Latitude"));
					ville.setLibelleAcheminement(resultat.getString("Libelle_acheminement"));
					ville.setLigne5(resultat.getString("Ligne_5"));
					ville.setLongitude(resultat.getString("Longitude"));
				}

			}
		} catch (Exception e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, "contexte", e);
		} finally {
			pstmt.close();
			
		}
		return ville;

	}

	@Override
	public String supprimeVillesCP(String cp) throws SQLException {

		Connection connexion = null;
		java.sql.PreparedStatement pstmt = null;
		String query = "DELETE FROM ville_france WHERE Code_commune_INSEE ="+cp+" ;";

		connexion = jdbcConfiguration.getConnection();
		try {
			pstmt = connexion.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, "contexte", e);
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

		}
		return "Ville supprimé";
	}

	@Override
	public String insertVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude) throws SQLException {
		Connection connexion = null;
		java.sql.PreparedStatement pstmt = null;
		String query = "INSERT INTO ville_france "
				+ "(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) "
				+ "VALUES" + "(\""+codeInsee+"\",\""+commune+"\",\""+cp+"\",\""+libelle+"\",\""+ligne5+"\",\""+latitude+"\",\""+longitude+"\");";
		connexion = jdbcConfiguration.getConnection();
		try {
			pstmt = connexion.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, "contexte", e);
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

		}
		return "Ville inséré";
	}

	@Override
	public String updateVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude) throws SQLException {
		Connection connexion = null;
		java.sql.PreparedStatement pstmt = null;
		String query = "UPDATE ville_france " + "SET `Code_commune_INSEE` = \""+codeInsee+"\"" + ",`Nom_commune` = \""+commune+"\""
				+ ",`Code_postal` = \""+cp+"\"" + ",`Libelle_acheminement` = \""+libelle+"\"" + ",`Ligne_5` = \""+ligne5+"\""
				+ ",`Latitude` = \""+latitude+"\"" + ",`Longitude` = \""+longitude+"\"" + " WHERE Code_commune_INSEE = \""+codeInsee+"\";";
		connexion = jdbcConfiguration.getConnection();
		try {
			pstmt = connexion.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, "contexte", e);
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return "Ville mise Ã  jour";
	}

}
