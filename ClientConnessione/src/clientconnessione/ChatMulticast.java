/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

import static clientconnessione.grafica.Text;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattia
 */
public class ChatMulticast extends Thread{
     MulticastSocket conn;
     int porta=3000;
     InetAddress addres;
     grafica g;
     String indirizzo="224.0.0.1";
//     DatagramSocket clientSocket = null;
     byte[] sendData =new byte[1024]; 
        byte[] receiveData = new byte[1024]; 
     public ChatMulticast(){
         try {
            
            conn=new MulticastSocket(porta);
            addres=InetAddress.getByName(indirizzo);
            conn.joinGroup(addres);
//            clientSocket = new DatagramSocket();
         } catch (IOException ex) {
             Logger.getLogger(ChatMulticast.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }
     public void invia(String sentence){
         
         sendData = sentence.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,addres,porta); 
         try {
             
             conn.send(sendPacket);
             System.out.println("funge");
         } catch (IOException ex) {
             Logger.getLogger(ChatMulticast.class.getName()).log(Level.SEVERE, null, ex);
         }
     }

   
    @Override
     public  void run(){
         String risposta;
         
         for(;;){
     
         try { 
             //receiveData=new byte[1024];
             DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length); 
             conn.receive(receivePacket);
             risposta = new String(receivePacket.getData()); 
             System.out.println(risposta.substring(0, receivePacket.getLength()));
             grafica.Text.setText(grafica.Text.getText()+"\n"+risposta);
             grafica.jtext.setText("");
         } catch (IOException ex) {
             Logger.getLogger(ChatMulticast.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         
     }
}
