/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author mattia
 */
public class GeneraCod {
    String codicef;
    ArrayList <String> codice;
    
    
    public GeneraCod(){
       
       codice=new ArrayList <String>();
    }

  
    public void genera() {
        int i=0;
        while(codice.size()<4){
            i=ThreadLocalRandom.current().nextInt(0,9+1);  
            if(!codice.contains(Integer.toString(i))){
                codice.add(String.valueOf(i));
            }
        }
        codicef="";
        for(String cod: codice){
            codicef=codicef+cod;
        }
        
        
    }
    public int verifica(String cod){
        
        char codi[]=cod.toCharArray();
        char codvero[]=this.codicef.toCharArray();
        int contatore=0;
        for(int i=0;i<4;i++){
            if(codi[i]==codvero[i]){
                contatore++;
            }
        }
        return contatore;
    }
        public int verificaBall(String cod){
       
        char codi[]=new char[4];
        codi=cod.toCharArray();
        char codvero[]=new char[4];
        codvero=this.codicef.toCharArray();
        int contatore=0;
        for(char c: codi){
            for(char d: codvero){
                if(c==d){
                    contatore++;
                }
            }
        }
       
        return contatore;
    }
    
}
