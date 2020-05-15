/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.societe;

/**
 *
 * @author ASUS
 */
public class DetailsC extends Form{
    Form current;
  
       
    public DetailsC(CommandeF s) {
        
       current=this;
          Form previous = Display.getInstance().getCurrent();
                      setTitle("Farcture");                                                                                                                                                                                                               
         Label k = new Label("Facture Num°"+s.getIdm());
           Label m=new Label("                      ");
            
                
     Label lnom = new Label("Societe");
     lnom.setText("nom Societe : "+s.getSociete().getNames());
     Label n=new Label("                   ");
  
            
     Label laddress= new Label("Produit ");
     laddress.setText("Produit:"+s.getProduit().getPrix());
      Label mail = new Label("Quantite");
      Label tel = new Label("Date");
      mail.setText("Ouantite: "+s.getQuantite());
      tel.setText("Date: "+s.getDate());
   Label total = new Label ("Total");
   int Quant=s.getQuantite();
   Float pr= s.getProduit().getPrix();
   total.setText("Total =:"+pr*Quant);
   Label nn=new Label("                   ");

      current.add(k);
     current.add(m);
     current.add(lnom);
    
     current.add(n);
     current.add(laddress);
     current.add(mail);
     current.add(tel);
       current.add(total);
       current.add(nn);
      
       current.show();
      
 
     
     
                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

        
    }}
