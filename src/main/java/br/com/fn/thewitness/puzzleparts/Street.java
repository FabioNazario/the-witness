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
public class Street extends PuzzleObject {
    
    boolean filled = false;
    
    //GETTERS AND SETTERS

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }    
}
