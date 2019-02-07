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
public class ServerConnessione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MultiThreadServer mts=new MultiThreadServer();
        mts.accettaCon();
    }
    
}
