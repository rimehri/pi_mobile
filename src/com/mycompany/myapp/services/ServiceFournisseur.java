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
import com.mycompany.entities.societe;
import com.mycompany.myapp.utils.Statics;

/**
 *
 * @author ASUS
 */
public class ServiceFournisseur {
     public boolean resultOK;
     
       public boolean addfournisseur(societe t) {
        String url = Statics.BASE_URL +"/societe/" + t.getNames()+"/"+t.getAddress()+"/"+t.getEmail()+"/"+t.getTel()+"/"+t.getLogo(); // cree l'url
          ConnectionRequest req = new ConnectionRequest(url); // créer la requete 
         
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
