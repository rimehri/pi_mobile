/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;


/**
 *
 * @author admin
 */
public class ServiceReclamation {
     public boolean resultOK;
     
       public boolean addReclamation(Reclamation t) {
        String url = Statics.BASE_URL +"/Reclamation/" + t.getDesignation()+"/"+t.getDescription()+"/"+t.isEtat()+"/"+t.getDate(); // cree l'url
          ConnectionRequest req = new ConnectionRequest(url); // créer la requete 
           // ajouter une action  à la reception de la réponse
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
}