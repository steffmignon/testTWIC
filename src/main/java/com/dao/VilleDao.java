package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;

public interface VilleDao {

	public  List<Ville> afficheVilles() throws JSONException, SQLException;
	public Ville chercheVillesCP(String cp) throws SQLException;
	public String supprimeVillesCP(String cp) throws SQLException;
	public String insertVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude) throws SQLException;
	String updateVille(String commune, String codeInsee, String cp, String libelle, String ligne5, String longitude,
			String latitude) throws SQLException;
}