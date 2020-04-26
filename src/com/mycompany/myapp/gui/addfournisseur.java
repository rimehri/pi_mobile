/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ShareButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
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
      /* DropTarget dnd;
        dnd = DropTarget.(evt)->{
            String srcFile = (String)evt.getSource();
            System.out.println("Src file is "+srcFile);
            System.out.println("Location: "+evt.getX()+", "+evt.getY());
            if (srcFile != null) {
                try {
                    Image img = Image.createImage(FileSystemStorage.getInstance().openInputStream(srcFile));
                    me.add(img);
                    me.revalidate();
                } catch (IOException ex) {
                    Log.e(ex);
                }
            }
        }, Display.GALLERY_IMAGE);

me.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
me.setScrollableY(true);*/
      
      
      
      
      /*ShareButton sb = new ShareButton();
sb.setText("Share Screenshot");
me.add(sb);

Image screenshot = Image.createImage(me.getWidth(), me.getHeight());
me.revalidate();
me.setVisible(true);
me.paintComponent(screenshot.getGraphics(), true);

String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
    ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
} catch(IOException err) {
    Log.e(err);
}
sb.setImageToShare(imageFile, "image/png");*/
          addAll(tnom,tadress,tmail,ttel,btnValider);
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
   }
}
