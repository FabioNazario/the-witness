/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fn.thewitness.puzzleparts;

/**
 *
 * @author Fabio Nazario
 */
public class Intersection {

    boolean startPoint;
    boolean endPoint;
    boolean filled;

    //GETTERS AND SETTERS

    public boolean isStartPoint() {
        return startPoint;
    }

    public void setStartPoint(boolean startPoint) {
        this.startPoint = startPoint;
        if (startPoint){
            this.endPoint = false;
        }
    }

    public boolean isEndPoint() {
        return endPoint;
    }

    public void setEndPoint(boolean endPoint) {
        
        this.endPoint = endPoint;
        
        if (endPoint){
            this.startPoint = false;
        }

    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    

    
    
}
