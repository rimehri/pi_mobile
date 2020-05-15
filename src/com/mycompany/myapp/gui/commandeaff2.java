/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.CommandeF;
import com.mycompany.myapp.services.ServiceCommandef;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class commandeaff2 extends Form{
        SpanLabel lb;
    Form accueilf;
    String[] commandes = {"Modifier", "Details"};
       ServiceCommandef myServices = new ServiceCommandef();
        ArrayList<CommandeF> list = myServices.getAllTasks();
    public commandeaff2(Form previous) {
        accueilf=this;
        setTitle("les commandes");
        setLayout(BoxLayout.y());
        
        Toolbar.setGlobalToolbar(true);

accueilf.getToolbar().addSearchCommand(e -> {
});
 if (list.isEmpty()) {
            SpanLabel lb = new SpanLabel(" acune commandes !");
           accueilf.add(lb);
        } else {

            for (CommandeF r : list) {

                MultiButton b = new MultiButton("");
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIdm());
                b.setTextLine3("Societe \n:" + r.getSociete().getNames());
                  accueilf.add(b);
                  
                  
                  
                   b.addActionListener(e -> {
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    d.getContentPane().setScrollableY(true);
                    for (String cmd : commandes) {
                        MultiButton mb = new MultiButton(cmd);
                        d.add(mb);
                        mb.addActionListener(ee -> {

                            switch (cmd) {

                                case "Modifier":
                                    ModifC  c = null;
                            try {
                                c = new ModifC(r);
                            } catch (IOException ex) {
                                System.out.println("ok");
                            }
                                   c.show();
                                    
                                    break;
                                default:

                            
                                   
                                 DetailsC k = new DetailsC(r);
                                   k.show();
                            
                                   
                                    
                                    break;
                            }

                            
                        });
                    }
                    d.showPopupDialog(b);

                });
                 /* b.addActionListener(e->{
                    
 DetailsC d = new DetailsC(r);
 d.show();
 });        
            }*/
          
 }}
                

       
        
        accueilf.add(new InfiniteProgress());
        getToolbar().addMaterialCommandToRightBar(
                   "", FontImage.MATERIAL_ADD, 6f,( ActionEvent e) -> {
            try {
                new addcomm(accueilf).show();
            } catch (IOException ex) {
                System.out.println("err");            }
        });
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
   
    }
}

