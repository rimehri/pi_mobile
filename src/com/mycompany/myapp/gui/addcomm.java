/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.CategorieF;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.societe;
import com.mycompany.myapp.services.ServiceCategorief;
import com.mycompany.myapp.services.ServiceCommandef;
import com.mycompany.myapp.services.ServiceFournisseur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class addcomm extends Form{
    Form me ;
     ComboBox combo;
       public ArrayList<CategorieF> tasks;
      public addcomm(Form previous) throws IOException {
        me=this;
        setTitle("Add  a new commande");
        setLayout(BoxLayout.y());
         TextField tnom = new TextField("","nom Produit");
        TextField Quantite= new TextField("", "Quantite");
                TextField Prix= new TextField("", "Prix",0,TextField.NUMERIC);

         Picker date = new Picker();
         
       
                  

       Button btnValider = new Button("Add Commande");
        addAll(tnom,Quantite,Prix,date,btnValider);
       btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
               if ((Quantite.getText().length()==0))
           Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
           else
           {
           try {
           CommandeF t = new CommandeF(date.getDate(),Integer.parseInt(Quantite.getText()));
        
                       if( ServiceCommandef.getInstance().addcomm(t))
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                       else
                           Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                       Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                   }
                    
           }
                
                });
      
         
    
       
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
           }
}