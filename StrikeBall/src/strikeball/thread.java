/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.net.Socket;

/**
 *
 * @author mattia
 */
public class thread extends Thread{
    Socket con;
    Messaggi ms;
    thread(Socket socket) {
        this.con=socket;
        ms=new Messaggi(con);
    }

    @Override
    public void run() {
        GeneraCod gc=new GeneraCod();
        
        int parole,dif;
        String cs="";
        String verifica="";
        while(true){
            dif=Integer.parseInt(ms.leggi());
            gc.genera();
            System.out.println(gc.codicef);
            ms.scrivi(gc.codicef);
            
            for(int i=0;i<dif;i++){
                cs=ms.leggi();
                parole=gc.verifica(cs);
                if(parole==4){
                    ms.scrivi("1111");
                    con=null;
                    break;
                }
                else{
                    int ball=gc.verificaBall(cs)-parole;
                    verifica=Integer.toString(parole);
                    verifica=verifica+","+ball;
                    ms.scrivi(verifica);
                }
            }
            
            con=null;
        }
    }

    
}
