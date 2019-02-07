/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

/**
 *
 * @author mattia
 */
 import java.util.Scanner;
public class gioco {
    String cod;
    int i=0;
    public gioco(){
    cod="";
    }
    public void crea(String ice){
        /*Scanner reader = new Scanner(System.in);
        System.out.println("inserisci 4 numeri da 0 a 9 senza ripetizioni");
        cod=reader.nextLine();*/
        i++;
        
        cod=cod+ice;
        if(i==4){
        System.out.println(cod);
        }
    }
    public char togli(){
        i--;
        char d=cod.charAt(cod.length()-1);
        cod=cod.substring(0, cod.length() - 1);
        return d;
    }
    public int difficoltà(){
        Scanner reader = new Scanner(System.in);
        System.out.println("inserisci livello di difficoltà 1(basso) 2(medio) 3(alto)");
        int dif=reader.nextInt();
        switch(dif){
            case 1:
                dif=6;
                break;
            case 2:
                dif=4;
                break;
            case 3:
                dif=3;
        }
        return dif;
    }
}
