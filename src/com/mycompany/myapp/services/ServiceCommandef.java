/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.produit;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class ServiceCommandef {
    
    
    
        public ArrayList<CommandeF> tasks;
    
    public static ServiceCommandef instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCommandef() {
         req = new ConnectionRequest();
    }

    public static ServiceCommandef getInstance() {
        if (instance == null) {
            instance = new ServiceCommandef();
        }
        return instance;
    }
     public ArrayList<CommandeF> parseTasks(String jsonText) throws ParseException{
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

           
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
        
              CommandeF t = new CommandeF();
             
                float id = Float.parseFloat(obj.get("idm").toString());
                t.setIdm((int)id);
                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
           //      
                // SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd");
                  //  t.setDate((Date)(sdf.parse(obj.get("date").toString())));

                   Map<String, Object> listmembre = (Map<String, Object>) obj.get("idp");
                produit p = new produit();
//             p.setNom((String) listmembre.get("nom"));
              
              // float prix = Float.parseFloat(obj.get("prix").toString());
            //    p.setPrix(prix);
               
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
    
    public ArrayList<CommandeF> getAllTasks(){
        String url = "http://localhost/FINAL symfony/final/web/app_dev.php/listcom";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    tasks = parseTasks(new String(req.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("error");
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
}
