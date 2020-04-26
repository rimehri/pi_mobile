/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author admin
 */
public class AddReclamationForm  extends Form{

   public AddReclamationForm(Form previous) {
        
        setTitle("Add  a new reclamation");
        setLayout(BoxLayout.y());
         TextField tfDesignation = new TextField("","Reclamation");
        TextField tfDescription= new TextField("", "Description");
        TextField tfEtat= new TextField("", "Status: 0 - 1");
        TextField tfDate= new TextField("", "Date: 25/04/2020");
         
        Button btnValider = new Button("Add Reclamation");
       // btnValider.addActionListener(new ActionListener() {
          //  @Override
           /* public void actionPerformed(ActionEvent evt) {
                if ((tfDesignation.getText().length()==0)|| (tfDesignation.getText().length()==0)||(tfEtat.getText().length()==0)){
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));}
                else
                {
                     try {
//                       //  Reclamation t =new Reclamation(Boolean.parseBoolean(tfEtat.getText()),tfDesignation.getText(),tfDesignation.getText(),date);
                     
                       //Reclamation t = new Reclamation(Integer.parseInt(tfEtat.getText()),tfDesignation.getText(),tfDesignation.getText(), tfDate.getText());
                     }
                     catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
            }
                

        
                
                }}*/
           
    
   
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
   }}