/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class MultiThreadServer {
    ServerSocket sSocket = null;
    int porta=3000;
    public MultiThreadServer(){
        try {
            sSocket = new ServerSocket(porta);
            
        } catch (IOException ex) {
            Logger.getLogger(MultiThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void accettaCon(){
        for(;;){
            System.out.println("in attesa di connessioni...");
            try {
               Socket socket = sSocket.accept();
               thread tr=new thread(socket);
               tr.start();
            } catch (IOException ex) {
                Logger.getLogger(MultiThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
