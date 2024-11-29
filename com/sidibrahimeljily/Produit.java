package com.sidibrahimeljily;

import java.math.BigDecimal;

public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;
    // Constructeur par defaut.
    public Produit() {
    }
    //Constructeur avec argument pour creer un objet et passer les attributes au moment de creation.

    public Produit(int code, String nom, double prix, int quantite) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Getters and Setters ce sont des methodes pour modifier l'etat d'un objet .
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    //to string pour afficher les informations d'un produit.
    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }

    public Double calculerTotalProduit(){
        return this.quantite*this.prix;
    }
}
