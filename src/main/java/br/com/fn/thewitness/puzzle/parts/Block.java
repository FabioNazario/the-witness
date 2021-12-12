package br.com.fn.thewitness.puzzle.parts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio Nazario
 */
public class Block{
    
    Street upStreet;
    Street rightStreet;
    Street downStreet;
    Street leftStreet;
    
    //GETTERS AND SETTERS

    public Street getUpStreet() {
        return upStreet;
    }

    public void setUpStreet(Street upStreet) {
        this.upStreet = upStreet;
    }

    public Street getRightStreet() {
        return rightStreet;
    }

    public void setRightStreet(Street rightStreet) {
        this.rightStreet = rightStreet;
    }

    public Street getDownStreet() {
        return downStreet;
    }

    public void setDownStreet(Street downStreet) {
        this.downStreet = downStreet;
    }

    public Street getLeftStreet() {
        return leftStreet;
    }

    public void setLeftStreet(Street leftStreet) {
        this.leftStreet = leftStreet;
    }
    
    
    
}
