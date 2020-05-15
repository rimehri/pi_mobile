/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.societe;
import com.mycompany.myapp.services.ServiceFournisseur;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DetailsF extends Form{
    Form current;
  
       
    public DetailsF(societe s) {
        
       current=this;
          Form previous = Display.getInstance().getCurrent();
        
    
   
                                                                                                                                                                                                                               
         Label k = new Label("fournisseur Num°"+s.getIds());
           Label m=new Label("                      ");
            
                
     Label lnom = new Label("nom");
     lnom.setText("nom : "+s.getNames());
     Label n=new Label("                   ");
  
            
     Label laddress= new Label("Adress");
     laddress.setText("address:"+s.getAddress());
      Label mail = new Label("mail");
      Label tel = new Label("telephone");
      mail.setText("email: "+s.getEmail());
      tel.setText("Telephone : "+s.getTel());
   
      current.add(k);
     current.add(m);
     current.add(lnom);
    
     current.add(n);
     current.add(laddress);
     current.add(mail);
     current.add(tel);
       
       current.show();
      
 
     
     
                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

    
                 
    }
    
}
