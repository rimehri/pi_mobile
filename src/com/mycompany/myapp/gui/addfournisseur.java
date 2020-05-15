/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ShareButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author ASUS
 */
public class addfournisseur extends Form{
    Form me ;
      public addfournisseur(Form previous) throws IOException {
        me=this;
        setTitle("Add  a new Fournisseur");
        setLayout(BoxLayout.y());
         TextField tnom = new TextField("","nom");
        TextField tadress= new TextField("", "address");
        TextField tmail= new TextField("", "email");
        TextField ttel= new TextField("", "numéro de telephone");
        
       
      

       Button btnValider = new Button("Add Fournisseur");
      
      
      
          addAll(tnom,tadress,tmail,ttel,btnValider);
       
                

        
                
            
           
    
   
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
   }
}
