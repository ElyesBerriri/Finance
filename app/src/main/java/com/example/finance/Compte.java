package com.example.finance;

public class Compte {

    public String id="";
    public float solde=0f;
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

    public Compte(String i, float s, float im, float jan, float fev, float mars, float avr, float mai, float jun,
                  float juil, float aout, float sep, float oct, float nov, float dec) {
        this.id = i;
        this.solde = s;
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

    public String get_id() {
        return id;
    }

    public float getSolde() {
        return solde;
    }
}
