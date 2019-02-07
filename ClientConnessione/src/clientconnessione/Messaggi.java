/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class Messaggi {
    DataOutputStream dOut =null;
    DataInputStream dIn=null;
    
    public Messaggi(Socket connessione){
        try {
            dIn = new DataInputStream(connessione.getInputStream());
            dOut = new DataOutputStream(connessione.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String codice){
        try {
            //invio messaggio
            //dOut.writeInt(Integer.parseInt(codice));
            dOut.writeUTF(codice);
            
        } catch (IOException ex) {
            Logger.getLogger(Connessione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        int codice=0;
        String codic="";
        try {
            System.out.println("ascolto");
            
           //codice=dIn.readInt();
           codic=dIn.readUTF();
           System.out.println(codic);
            
        } catch (IOException ex) {
            Logger.getLogger(Messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codic;
    }

   
}
