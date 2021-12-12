/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fn.the.witness;

import br.com.fn.thewitness.puzzleparts.Street;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Fabio Nazario
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println(String.format("%02d", 2));
        
        boolean isClear = false;
        
        
        
        Puzzle p = new Puzzle(5,5, new Coordenate(0,0), new Coordenate(2,0));
        
        p.print();
        
       while(!isClear){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = br.readLine();
            key = key.toUpperCase();
            isClear = p.move(key);
       }
       
        System.out.println("\n\n\n\n\n\n\n\n\nCLEAR!!!!!!");
       /* p.move("R");
        p.move("R");p.move("R");p.move("R");
        p.move("D");
        p.move("L");
        p.move("D");
        p.move("L");
        p.move("R");
        p.move("U");
        p.move("R");
        p.move("U");d
        
        p.move("L");
        p.move("L");
        */
 
        
    }
}
