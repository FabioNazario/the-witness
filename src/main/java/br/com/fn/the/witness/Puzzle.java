/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fn.the.witness;

import br.com.fn.thewitness.puzzleparts.Block;
import br.com.fn.thewitness.puzzleparts.Intersection;
import br.com.fn.thewitness.puzzleparts.Street;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Fabio Nazario
 */
public class Puzzle {
    
    int width;
    int height;
    Block[][] blocks;
    Intersection[][] intersections;
    HashMap<String, Street> streetMap = new HashMap<>();
    Coordenate startPoint = new Coordenate(0,0);
    Coordenate endPoint = new Coordenate(0,0);
    Coordenate currentPoint = new Coordenate(0,0);
    Stack<Coordenate> path = new Stack<Coordenate>();



    
    public Puzzle(int width, int height, Coordenate startPoint, Coordenate endPoint) {
        this.width = width;
        this.height = height;
        this.startPoint.setX(startPoint.getX());
        this.startPoint.setY(startPoint.getY());
        this.endPoint.setX(endPoint.getX());
        this.endPoint.setY(endPoint.getY());
        this.currentPoint.setX(startPoint.getX());
        this.currentPoint.setY(startPoint.getY());
        path.push(startPoint);
        
        this.initBlocks();
        this.initIntersections();
        this.initStreets();
        
        intersections[startPoint.getX()][startPoint.getY()].setFilled(true);
    }
    
    private void initBlocks(){
        
        blocks = new Block[width][height];
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                blocks[i][j] = new Block();
            }  
        }
    }
    
    private void initIntersections(){
        
        int interWidth = width + 1;  
        int interHeight = height + 1;  
        
        intersections = new Intersection[interWidth][interHeight];
        
        for (int i = 0; i < interWidth; i++) {
            for (int j = 0; j < interHeight; j++) {
                intersections[i][j] = new Intersection();
                
                if (startPoint.getX() == i && startPoint.getY() == j){
                    intersections[i][j].setStartPoint(true);
                }
                
                if (endPoint.getX() == i && endPoint.getY() == j){
                    intersections[i][j].setEndPoint(true);
                } 
            }  
        }
    }
    
    private void initStreets(){
        
        String keymap = "";
        
        for (int i = 0; i < width + 1; i++) {
            for (int j = 0; j < height + 1; j++) {
                
                streetMapMaker(i, j, i+1,j);
                streetMapMaker(i, j, i-1,j);
                streetMapMaker(i, j, i, j+1);
                streetMapMaker(i, j, i, j-1);

            }  
        }
    }
    
    private void streetMapMaker(int i1, int j1, int i2, int j2 ){
        
        Coordenate corTo = new Coordenate(i2,j2);
        
        if (!isValidMapCoordenate(corTo)){
        return;
        }
        
        String fromMapCoord = String.format("%02d", i1) + String.format("%02d", j1);
        String toMapCoord =  String.format("%02d", i2) + String.format("%02d", j2);
        
        
        String keymap = fromMapCoord + "-" + toMapCoord;
        
        String keymapInverse = toMapCoord + "-" + fromMapCoord;
        
        Street currStreet = streetMap.get(keymapInverse);
        
        if (currStreet != null){
            streetMap.put(keymap, currStreet);
        }else{
            streetMap.put(keymap, new Street());
        }
        
    }
    
    public void print(){
        int interWidth = width + 1;  
        int interHeight = height + 1;  
        String value = " ";        
        for (int i = 0; i < interWidth; i++) {
            for (int j = 0; j < interHeight; j++) {
                    
                if(intersections[i][j].isEndPoint()){
                    value = "F";
                }
                
                if(intersections[i][j].isFilled()){
                    value = "x";
                }
                
                System.out.print("[" +value+ "]");
                
                value = " ";
            }  
            System.out.println("");
        }
    
        System.out.println("-----------------------");
    }
    
    public boolean move(String direction){
        
        Coordenate testPoint = new Coordenate(currentPoint.getX(), currentPoint.getY());

        if ("D".equals(direction)){
            testPoint.setY(testPoint.getY()+1);   
        }
        
        if ("A".equals(direction)){
            testPoint.setY(testPoint.getY()-1);   
        }
        
        if ("S".equals(direction)){
            testPoint.setX(testPoint.getX()+1);   
        }
        
        if ("W".equals(direction)){
            testPoint.setX(testPoint.getX()-1);   
        }
        
        
        if (!isValidMoveCoordenate(testPoint)){
            print();
            return false;
        }
        
        if (isBackMove(testPoint)){
            
            System.out.println("is back move!!!");
            intersections[currentPoint.getX()][currentPoint.getY()].setFilled(false);
            path.pop();
            path.pop();
        }
        
        currentPoint.setX(testPoint.getX());
        currentPoint.setY(testPoint.getY());
        intersections[currentPoint.getX()][currentPoint.getY()].setFilled(true);

        path.push(new Coordenate(testPoint.getX(), testPoint.getY()));
        print();
        
        return isClear();
        
    }
    
    private boolean  isValidMapCoordenate(Coordenate c){
        
        if (c.getX() < 0 || c.getX() > width || c.getY() < 0 || c.getY() > height){
            return false;
        }

        return true;
    }
    
    private boolean  isValidMoveCoordenate(Coordenate c){
        
        
        if (!isValidMapCoordenate(c)){
            return false;
        }

        boolean oba = isBackMove(c);
        
        if(!isBackMove(c) && intersections[c.getX()][c.getY()].isFilled()){
            return false;
        }
        
        return true;
    }
    
    public boolean isClear(){
        
        if (currentPoint.equals(endPoint)){
            return true;
        }
        
        return false;
    }
    
     private boolean isBackMove(Coordenate c){
         
         
         if (path.size() < 2){
            return false;
         }
         System.out.print(path.get(path.size() -2).getX() + ", ");
         System.out.println(path.get(path.size() -2).getY());
         System.out.print(c.getX() + ", ");
         System.out.println(c.getY());

        if (path.get(path.size() -2).equals(c)){
            return true;
        }
        
        return false;
    }
    
    
    
    //GETTERS AND SETTERS

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return height;
    }

    public void setHeigth(int height) {
        this.height = height;
    }
    
    
}




