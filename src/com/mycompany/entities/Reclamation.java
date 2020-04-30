/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Reclamation {

    private String designation;
    private String description;
    private boolean etat;
    private String date;
    private CategorieR  categorie ; 

    public Reclamation(String designation, String description, boolean etat, String date, CategorieR categorie) {
        this.designation = designation;
        this.description = description;
        this.etat = etat;
        this.date = date;
        this.categorie = categorie;
    }

    public CategorieR getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieR categorie) {
        this.categorie = categorie;
    }



    public Reclamation() {
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + ", designation=" + designation + ", description=" + description + ", etat=" + etat + ", date=" + date + '}';
    }

}
