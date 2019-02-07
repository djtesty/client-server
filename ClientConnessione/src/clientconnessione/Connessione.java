/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class Connessione {
    Socket connessione = null;
   
    
    //definizione dell'indirizzo del server e la porta in ascolto
    String server =null;
    int porta =3000;
    
    public Connessione(){
        server="localhost";
    }
    
    public void conntetti(){
         try {
             
            //connessione alla porta aperta precedentemente
            connessione=new Socket(server,porta);
            System.out.println("connessione aperta");
            
            
    }   catch (IOException ex) {
            Logger.getLogger(Connessione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String codicei){
        Messaggi ms=new Messaggi(connessione);
        ms.scrivi(codicei);
    }
    
    public String[] leggi(){
        Messaggi ms=new Messaggi(connessione);
        String codice=ms.leggi();
        String split[]=new String[2];
        split=codice.split(",");
        
           if(Integer.parseInt(split[0])<5){
               System.out.println("hai preso "+codice+" posizioni");
           }
           else{
               System.out.println(codice);
           }
           return split;
    }
    
    public void chiudi(){
        try {
            //chiusura della connessione all porta 3000
            connessione.close();
            System.out.println("connessione chiusa");
        } catch (IOException ex) {
            Logger.getLogger(Connessione.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
