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
import com.mycompany.entities.CategorieR;
import com.mycompany.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ServiceReclamation {

    public ArrayList<Reclamation> recs;
    public static ServiceReclamation instance;
    private final ConnectionRequest req;
    public boolean resultOK;

    public ServiceReclamation() {
        req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public boolean addReclamation(Reclamation t) {
        String url = Statics.BASE_URL + "/Reclamation/" + t.getDesignation() + "/" + t.getDescription() + "/" + "/" + t.getDate(); // cree l'url
        //ConnectionRequest req = new ConnectionRequest(url); // créer la requete 
        // ajouter une action  à la reception de la réponse
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //vérifier le statut de la réponse
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                //  req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }

    public ArrayList<Reclamation> parseTasks(String jsonText) throws ParseException {
        try {
            recs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Reclamation t = new Reclamation();

                t.setDesignation(obj.get("designation").toString());
                t.setDescription(obj.get("description").toString());
                t.setDate(obj.get("date").toString());
                t.setEtat(Boolean.valueOf(obj.get("etat").toString()));
                //   t.setCategorie((CategorieR) obj.get("Categorie"));
                //Ajouter la tâche extraite de la réponse Json à la liste
                recs.add(t);
            }

        } catch (IOException ex) {

        }

        return recs;
    }

    public ArrayList<Reclamation> getAllrecs() {
        String url = "http://localhost/final/web/app_dev.php/Reclamation/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    recs = parseTasks(new String(req.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("error");
                }

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return recs;
    }
}
