package com.dao;

public class Ville {

    private int codeINSEE;
    private String nomCommune;
    private int codePostal;
    private String libelleAcheminement;
    private String ligne5;
    private String lattitude;
    private String longitude;

    public Ville(int codeINSEE,String commune,int cp,String libelleAcheminement,
    		String ligne5, String lattitude, String longitude) {
        this.codeINSEE = codeINSEE;
        this.nomCommune = commune;
        this.codePostal = cp;
        this.libelleAcheminement = libelleAcheminement;
        this.ligne5 = ligne5;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Ville(Ville ville) {
    	this.codeINSEE = ville.getCodeINSEE();
        this.nomCommune = ville.getNomCommune();
        this.codePostal = ville.getCP();
        this.libelleAcheminement = ville.getLibelleAcheminement();
        this.ligne5 = ville.getLigne5();
        this.lattitude = ville.getLattitude();
        this.longitude = ville.getLongitude();
	}

	public Ville() {
		
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
        return codePostal;
    }
    public void setCP(int cP) {
        codePostal = cP;
    }
    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }
    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }
    public String getLigne5() {
        return ligne5;
    }
    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
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

	@Override
	public String toString() {
		return "Ville [codeINSEE=" + codeINSEE + ", nomCommune=" + nomCommune + ", CP=" + codePostal + ", libelleAcheminement="
				+ libelleAcheminement + ", ligne_5=" + ligne5 + ", lattitude=" + lattitude + ", longitude=" + longitude
				+ "]";
	}

}