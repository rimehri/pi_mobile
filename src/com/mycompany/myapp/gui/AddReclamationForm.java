/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.CategorieR;

import com.mycompany.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author admin
 */
public class AddReclamationForm  extends Form{
Form me1;
   public AddReclamationForm(Form previous) {
        me1=this;
        setTitle("Add  a new reclamation");
        setLayout(BoxLayout.y());
        TextField tfDesignation = new TextField("","Reclamation");
        TextField tfDescription= new TextField("", "Description");
        TextField tfEtat= new TextField("", "Status: en cours");
         Picker date = new Picker();
         
        Button btnValider = new Button("Add Reclamation");
         addAll( tfDesignation,tfDescription,tfEtat,date,btnValider);
              
         
         
             btnValider.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
         if ((tfDesignation.getText().length()==0)|| (tfDesignation.getText().length()==0)||(tfEtat.getText().length()==0)){
         Dialog.show("Alert", "Please fill all the fields", new Command("OK"));}
         else
         { 
             CategorieR categorieR = new CategorieR();
         Reclamation t= new Reclamation(tfDesignation.getText(),tfDescription.getText(),false,date.getDate().toString(),categorieR);
           if( new ServiceReclamation().addReclamation(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
              }
                
                
            }
        });
         
             
         
         
         
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
         
   } }
                 
                 
        
        
     
   
    
            


