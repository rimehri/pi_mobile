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
    private int id;
    private String designation;
    private String description;
    private boolean etat;
   private  Date date;   
 

    public Reclamation(int id, String designation, String description, boolean etat, Date date) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.etat = etat;
        this.date = date;
    }

    public Reclamation() {
    }



    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEtat() {
        return etat;
    }

   

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", designation=" + designation + ", description=" + description + ", etat=" + etat + ", date=" + date + '}';
    }
   
   
   
   
}
