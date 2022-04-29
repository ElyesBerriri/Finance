package com.example.finance;

public class Compte {

    public String id="";
    public float solde=0f;
    public float solde2=0f;
    public float interet=0f;
    public int jour;
    public int mois;
    public int annee;
    public float taux_impot=20f;
    public float taux_jan=2.5f;
    public float taux_fev=2.5f;
    public float taux_mars=2.5f;
    public float taux_avr=2.5f;
    public float taux_mai=2.5f;
    public float taux_jun=2.5f;
    public float taux_juil=2.5f;
    public float taux_aout=2.5f;
    public float taux_sep=2.5f;
    public float taux_oct=2.5f;
    public float taux_nov=2.5f;
    public float taux_dec=2.5f;

    public Compte(){}

    public Compte(String i, float s, float s2, float inter, int j, int m, int a, float im, float jan, float fev, float mars, float avr, float mai, float jun,
                  float juil, float aout, float sep, float oct, float nov, float dec) {
        this.id = i;
        this.solde = s;
        this.solde2 = s2;
        this.interet = inter;
        this.jour = j;
        this.mois = m;
        this.annee = a;
        this.taux_impot = im;
        this.taux_jan = jan;
        this.taux_fev = fev;
        this.taux_mars = mars;
        this.taux_avr = avr;
        this.taux_mai = mai;
        this.taux_jun = jun;
        this.taux_juil = juil;
        this.taux_aout = aout;
        this.taux_sep = sep;
        this.taux_oct = oct;
        this.taux_nov = nov;
        this.taux_dec = dec;
    }

    public String getId() {
        return id;
    }
    public float getSolde() {
        return solde;
    }
    public float getSolde2() {
        return solde2;
    }
    public float getInteret() {
        return interet;
    }
    public float getTaux_impot() {
        return taux_impot;
    }
    public int getJour() {
        return jour;
    }
    public int getMois() {
        return mois;
    }
    public int getAnnee() {
        return annee;
    }
    public float getTaux_avr() {
        return taux_avr;
    }
    public float getTaux_fev() {
        return taux_fev;
    }
    public float getTaux_aout() {
        return taux_aout;
    }
    public float getTaux_jan() {
        return taux_jan;
    }
    public float getTaux_dec() {
        return taux_dec;
    }
    public float getTaux_mars() {
        return taux_mars;
    }
    public float getTaux_juil() {
        return taux_juil;
    }
    public float getTaux_jun() {
        return taux_jun;
    }
    public float getTaux_mai() {
        return taux_mai;
    }
    public float getTaux_nov() {
        return taux_nov;
    }
    public float getTaux_oct() {
        return taux_oct;
    }
    public float getTaux_sep() {
        return taux_sep;
    }




    public void setSolde(float solde) {
        this.solde = solde;
    }
    public void setSolde2(float solde2) {
        this.solde2 = solde2;
    }
    public void setInteret(float interet) {
        this.interet = interet;
    }
    public void setJour(int jour) {
        this.jour = jour;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
