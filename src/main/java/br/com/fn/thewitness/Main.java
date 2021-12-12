/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fn.thewitness;

import br.com.fn.thewitness.puzzleparts.Street;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio Nazario
 */
public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
              
        boolean isClear = false;
        boolean isFinish = false;
        
        List<Coordenate> dotIntersectionList = new ArrayList<Coordenate>();
        
        dotIntersectionList.add(new Coordenate(2,2));
        dotIntersectionList.add(new Coordenate(3,3));
        dotIntersectionList.add(new Coordenate(4,4));
        
        Puzzle puzzle = new Puzzle(5,5, new Coordenate(0,0), new Coordenate(2,0), dotIntersectionList);
        
        while(!puzzle.isClear()){
            
            puzzle.reset();
            while(!puzzle.isFinish()){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String key = br.readLine();
                key = key.toUpperCase();
                puzzle.move(key);
            } 
            
            if (!puzzle.isClear()){
                System.out.println("WRONG!!! TRY AGAIN!! \nDeu mole, está errado seu otéééris!!!");
                Thread.sleep(3000L);
            }
  
        }
        
        System.out.println("CLEAR!!!!!! \nParabéns tirou ondaaa!!!"); 
        
    }
}
