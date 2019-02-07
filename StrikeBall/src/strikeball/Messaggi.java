/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class Messaggi {
    DataInputStream dIn=null;
    DataOutputStream dOut =null;
    public Messaggi(Socket connessione){
        try {
            dIn = new DataInputStream(connessione.getInputStream());
            dOut = new DataOutputStream(connessione.getOutputStream());
           
        } catch (IOException ex) {
            Logger.getLogger(Messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public String leggi(){
        int messageType=0;
        String messaggio="";
        try {
            //messageType = dIn.readInt();
            messaggio=dIn.readUTF();
            
            
            System.out.println("messaggio ricevuto "+messaggio);
        } catch (IOException ex) {
            Logger.getLogger(Messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggio;
                
    }
    
    public void scrivi(String cod){
        try {
            //dOut.writeInt(Integer.parseInt(cod));
            dOut.writeUTF(cod);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("messaggio inviato"+cod);
        
    }
}
