/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

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
public class ClientConnessione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                grafica g=new grafica();
               g.setVisible(true);
               
            }
        });
        
        
    }
    
}
