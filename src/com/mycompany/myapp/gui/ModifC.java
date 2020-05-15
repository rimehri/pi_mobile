/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.CategorieF;
import com.mycompany.entities.CommandeF;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ModifC extends Form{
    Form me ;
     ComboBox combo;
      Form previous = Display.getInstance().getCurrent();
       public ArrayList<CategorieF> tasks;
      public ModifC(CommandeF f) throws IOException {
        me=this;
        setTitle("Modifier commande");
        setLayout(BoxLayout.y());
         TextField tnom = new TextField("","nom Produit");
        TextField Quantite= new TextField("", "Quantite");
                TextField Prix= new TextField("", "Prix",0,TextField.NUMERIC);

         Picker date = new Picker();
         
       
                  

       Button btnValider = new Button("Modifier Commande");
        addAll(tnom,Quantite,Prix,date,btnValider);
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
      }

    
}
