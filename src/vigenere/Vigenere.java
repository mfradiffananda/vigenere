/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere;

import java.util.Scanner;

/**
 *
 * @author Radif
 */
public class Vigenere {

    /**
     * @param args the command line arguments
     */
    private static Scanner in;
    private static String message;
    private static String mappedKey;
    
    public static void main(String[] args) {
        // TODO code application logic here
        in = new Scanner(System.in);
        System.out.println("1. Enkripsi\n 2.Dekripsi\n pilih 1 atau 2 : ");
        int pilih=in.nextInt();
        in.nextLine();
     
        if(pilih==1){
            System.out.println("--ENKRIPSI--");
            psndankunci();
            chiperEnkripsi(message, mappedKey);
        }else if(pilih==2){
            
        }else{
            System.out.println("salah");
        }
    }
    
    public static void chiperEnkripsi(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String enkripText= "";
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == (char)32 && mappedKey.charAt(i)== (char)32){
                enkripText += "";
            }else{
                enkripText += (char)table[(int)message.charAt(i)-65][(int)mappedKey.charAt(i)-65];
            }
        }
        System.out.println("Enkripsi teks : ");
    }
    
    public static int createVigenereTable() {
        //create 26 table containing alpabhets
        int[][] tableArr = new int[26][26];
        for (int i=0;i<26;i++){
            for (int j=0;j<26;j++){
                int temp;
                if((i+65)+j > 90){
                    temp= ((i+65)+j)-26;
                    tableArr[i][j] = temp;
                }else{
                    temp=(i+65)+j;
                    tableArr[i][j] = temp;
                }
            }
        }
//        for (int i=0;i<26;i++){
//            for (int j=0;j<26;j++){
//                System.out.println((char)tableArr[i][j] + " ");
//            }System.out.printl1n();
//        }
        return 0;
    }
    
    public static void psndankunci() {
        System.out.println("--plainteks dan key harus alpabet--");
        
        //plainteks input
        System.out.println("masukan plainteks : ");
        String psn = in.nextLine();
        psn = psn.toUpperCase();
        
        //key input
        System.out.println("masukan key : ");
        String key = in.next();
        in.nextLine();
        key = key.toUpperCase();
        
        //mapping key ke plainteks
        String keyMap = "";
        for(int i=0, j=0; i<psn.length(); i++){
            if(psn.charAt(i)==(char)32){
                //ingnoring spasi
                keyMap += (char)32;               
            }else{
                //mapping plainteks dgn key
                if(j < key.length()){
                    keyMap +=key.charAt(j);
                    j++;
                }else{
                    j=0;
                    keyMap += key.charAt(j);
                    j++;
                }
            }
        }
        message = psn;
        mappedKey = keyMap;
        
        //System.out.println("plainteks : "+psn);
        //System.out.println("key : "+keyMap);
    }
}
