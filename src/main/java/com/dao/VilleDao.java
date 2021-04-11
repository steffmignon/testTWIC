package com.dao;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public interface VilleDao {

	public  List<Ville> afficheVilles() throws JSONException;
	public Ville chercheVillesCP(String cp);
	public String supprimeVillesCP(String cp);
	public String insertVille(String commune, String codeInsee, String cp, String libelle, String ligne5,
			String longitude, String latitude);
	String updateVille(String commune, String codeInsee, String cp, String libelle, String ligne5, String longitude,
			String latitude);
}
