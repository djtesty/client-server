/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.io.DataInputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class connessioni{
    ServerSocket sSocket = null;
    Socket connessione = null;
    int porta=3000;
    
    
    public connessioni(){
    }
    
    public void chiudi(Socket con){
        try {
            
            sSocket.close();
            System.out.println("connessione chiusa");
        } catch (IOException ex) {
            Logger.getLogger(connessioni.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void chiudi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
