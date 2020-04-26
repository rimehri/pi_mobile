/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;


/**
 *
 * @author ASUS
 */
public class Homefournisseur extends Form{
    Form accueilf;
    public Homefournisseur(Form previous) {
        accueilf=this;
        setTitle("Gestion Fournisseurs");
        setLayout(BoxLayout.y());
        
        Toolbar.setGlobalToolbar(true);

accueilf.getToolbar().addSearchCommand(e -> {
});

        add(new Label("les Fournisseurs"));
        accueilf.add(new InfiniteProgress());
        getToolbar().addMaterialCommandToRightBar(
                   "", FontImage.MATERIAL_ADD, 6f,( ActionEvent e) -> {
            try {
                new addfournisseur(accueilf).show();
            } catch (IOException ex) {
                System.out.println("err");            }
        });
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
   
    }
     
        

}

