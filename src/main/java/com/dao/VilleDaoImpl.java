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
	public String afficheVilles() {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        List<String> villes = new ArrayList<String>();
        String str = "";
            try {
				connexion = jdbcConfiguration.getConnection();
				statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT Nom_commune FROM ville_france;");
	            
	            while(resultat.next()) {
	            	villes.add(resultat.getString("Nom_commune"));
	            	str += "nom commune : "+resultat.getString("Nom_commune") + "<br/>";
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       System.out.println(str);
       return str;
	}
	
	public String chercheVillesCP(String cp) {
		
		Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        String result="";
            try {
				connexion = jdbcConfiguration.getConnection();
	            statement = connexion.prepareStatement("SELECT Nom_commune FROM ville_france WHERE Code_postal = ?;");
	            statement.setString(1, cp);
	            resultat = statement.executeQuery();
	            
	            resultat.next();
	            
	            result = resultat.getString("Nom_commune");
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
		
	}
}
