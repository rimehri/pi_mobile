/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.societe;
import com.mycompany.myapp.services.ServiceCommandef;
import com.mycompany.myapp.services.ServiceFournisseur;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author ASUS
 */
public class Homefournisseur extends Form{
       SpanLabel lb;
    Form accueilf;
       ServiceFournisseur myServices = new ServiceFournisseur();
        ArrayList<societe> list = myServices.getAllTasks();
    public Homefournisseur(Form previous) {
        accueilf=this;
        setTitle("Gestion Fournisseurs");
        setLayout(BoxLayout.y());
        
        Toolbar.setGlobalToolbar(true);

accueilf.getToolbar().addSearchCommand(e -> {
});
 add(new Label("les Fournisseurs"));
      
        
        getToolbar().addMaterialCommandToRightBar(
                   "", FontImage.MATERIAL_ADD, 6f,( ActionEvent e) -> {
            try {
                new addfournisseur(accueilf).show();
            } catch (IOException ex) {
                System.out.println("err");            }
        });
        
         if (list.isEmpty()) {
            SpanLabel lb = new SpanLabel(" acune commandes !");
           accueilf.add(lb);
        } else {

            for (societe r : list) {

                MultiButton b = new MultiButton("");
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIds());
                b.setTextLine3("Societe \n:" + r.getNames());
                  accueilf.add(b);
 b.addActionListener(e->{
                    
 DetailsF d = new DetailsF(r);
 d.show();
 });           
           /*  b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   
                    
                    

//preparer les Label dans details
                    Label pre1 = new Label("Names :");
                    Label bes1 = new Label("address:");
                    Label bn1 = new Label("email :");
                    Label dure = new Label("tel");
                    
//preparer les Span dans details
                    Label nom = new Label("");
                    SpanLabel pre = new SpanLabel("");
                    SpanLabel bes = new SpanLabel("");
         
                    SpanLabel bn = new SpanLabel("");
//l'ajout dans les span dans details
                    nom.setText(r.getNames());
                    pre.setText(r.getAddress());
                    bes.setText(r.getEmail());
                    bn.setText(r.getTel()); 
                
                accueilf.add(nom).add(pre).add(bes).add(bn);
                }
                 });*/
                    
                
                    
            
 
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
   
                
     
        
            }
         accueilf.add(new InfiniteProgress()); }
}
         }
