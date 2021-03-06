/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fn.thewitness;

import br.com.fn.thewitness.puzzle.util.Coordenate;
import br.com.fn.thewitness.puzzle.Puzzle;
import br.com.fn.thewitness.puzzle.parts.Street;
import br.com.fn.thewitness.ui.DisplayGraphics;
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
        
        int width = 3;
        int height = 7;
        
        DisplayGraphics d = new DisplayGraphics(width,height);
        //d.print();
          
        List<Coordenate> dotIntersectionList = new ArrayList<Coordenate>();
        
        dotIntersectionList.add(new Coordenate(2,2));
        dotIntersectionList.add(new Coordenate(3,3));
        //dotIntersectionList.add(new Coordenate(4,4));
        
        Puzzle puzzle = new Puzzle(height,width, new Coordenate(0,0), new Coordenate(2,0), dotIntersectionList);
        
        while(!puzzle.isClear()){
            
            puzzle.reset();
            while(!puzzle.isFinish()){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String key = br.readLine();
                key = key.toUpperCase();
                puzzle.move(key);
                d.repaint();
                
                
            } 
            
            if (!puzzle.isClear()){
                System.out.println("WRONG!!! TRY AGAIN!! \nDeu mole, está errado seu otéééris!!!");
                Thread.sleep(3000L);
            }
  
        }
        
        System.out.println("CLEAR!!!!!! \nParabéns tirou ondaaa!!!"); 
        
    }
}
