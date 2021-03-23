package com.dao;

public class Ville {

    private int codeINSEE;
    private String nomCommune;
    private int CP;
    private String libelleAcheminement;
    private String ligne_5;
    private String lattitude;
    private String longitude;

    public Ville(int codeINSEE,String commune,int cp,String libelleAcheminement,String ligne_5, String lattitude, String longitude) {
        this.codeINSEE = codeINSEE;
        this.nomCommune = commune;
        this.CP = cp;
        this.libelleAcheminement = libelleAcheminement;
        this.ligne_5 = ligne_5;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getCodeINSEE() {
        return codeINSEE;
    }
    public void setCodeINSEE(int codeINSEE) {
        this.codeINSEE = codeINSEE;
    }
    public String getNomCommune() {
        return nomCommune;
    }
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }
    public int getCP() {
        return CP;
    }
    public void setCP(int cP) {
        CP = cP;
    }
    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }
    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }
    public String getLigne_5() {
        return ligne_5;
    }
    public void setLigne_5(String ligne_5) {
        this.ligne_5 = ligne_5;
    }
    public String getLattitude() {
        return lattitude;
    }
    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }



}