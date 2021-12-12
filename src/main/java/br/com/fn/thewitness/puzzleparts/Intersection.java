package br.com.fn.thewitness.puzzleparts;

import br.com.fn.thewitness.puzzlechallanges.Dot;

public class Intersection {

    private boolean startPoint;
    private boolean endPoint;
    private boolean filled;
    private Dot dot;

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

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }
    
    
    
    

    
    
}
