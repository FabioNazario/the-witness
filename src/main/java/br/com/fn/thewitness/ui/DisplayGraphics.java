package br.com.fn.thewitness.ui;



import java.awt.*;  
import java.util.ArrayList;
import javax.swing.JFrame;  
  
public class DisplayGraphics extends JFrame{  
    
    //PARAMETERS
    public  int width;
    public  int height;
    
    //CONFIG
    public  int ajust = 20;
    public  int startX = 30;
    public  int startY = 30 + ajust;
    public  int streetWidth = 20;
    public  int inSquareSize = 50;

    //CALCULATED VALUES
    public static int x;
    public static int y;
    public static int firstDistanceValue;
    public static int commonDistance;
    public static int windowWidth;
    public static int windowHeight;
    
    ArrayList<Desenho> desenhos = new ArrayList<>();


    public DisplayGraphics(int width, int height) {
        
        this.width = width;
        this.height= height;

        //CALCULATED VALUES
        x = startX + streetWidth;
        y = startY + streetWidth;
        firstDistanceValue = x;
        commonDistance = streetWidth + inSquareSize;
        windowWidth = startX*2 + commonDistance * width + streetWidth;
        windowHeight = startY*2 + commonDistance * height;
        
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        new Time().start();
        
    }
    public void paint(Graphics g) { 
      
        
        
        for (int i = 1; i < desenhos.size(); i++) {
            
            
            int pathX = desenhos.get(i).x /(commonDistance + streetWidth/2);
            int pathY = (desenhos.get(i).y + ajust) /(commonDistance + streetWidth/2);
            
            
            //LIMITATE LINES
            if (desenhos.get(i).x < streetWidth/2 + startX){
                desenhos.get(i).x = streetWidth/2 + startX;
            }
            if (desenhos.get(i).y < streetWidth/2 + startY){
                desenhos.get(i).y = streetWidth/2 + startY;
            }
            
            if (desenhos.get(i).x > streetWidth/2 + startX + commonDistance * pathX){
                desenhos.get(i).x = streetWidth/2 + startX + commonDistance * pathX;
            }
            if (desenhos.get(i).y > streetWidth/2 + startY + commonDistance * pathY){
                desenhos.get(i).y = streetWidth/2 + startY + commonDistance * pathY;
            }
            
           
            
            /*
            g.clearRect(80, 80, 100, 100);
            g.drawString(desenhos.get(i).x + ", " + desenhos.get(i).y,100, 100);
            */
            
            
            g.drawRect(desenhos.get(i-1).x-5, streetWidth/2 + startY + commonDistance * pathY-5,10,10);
            g.drawLine(desenhos.get(i-1).x, streetWidth/2 + startY + commonDistance * pathY, desenhos.get(i).x, streetWidth/2 + startY + commonDistance * pathY);
            
            g.drawRect(streetWidth/2 + startX + commonDistance * pathX-5, desenhos.get(i-1).y-5,10,10);
            g.drawLine(streetWidth/2 + startX + commonDistance * pathX, desenhos.get(i-1).y, streetWidth/2 + startX + commonDistance*pathX, desenhos.get(i).y);

        }
        
        drawBasePuzzle(g);
        drawCurrent(g);
        drawPath(g);
    }  
    
    
    public void drawBasePuzzle(Graphics g){
        
        int x = this.x;
        int y = this.y;
        
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
  
                if (j == 0){
                    g.drawRect(x, y, inSquareSize, inSquareSize);
                }else{
                    g.drawRect(x += commonDistance, y, inSquareSize, inSquareSize);
                }

            }
            
            x = firstDistanceValue;
            y += commonDistance;
            
        }
        
        //Border square
        g.drawRect(startX,
                startY,
                firstDistanceValue + commonDistance * width - startX,
                firstDistanceValue + commonDistance * height - startY + ajust); 
    }
    
    public void draw(Graphics g){
        g.drawRect(30, 30, 70, 70);
        g.clearRect(30, 30, 70, 70);
    }
    public void drawCurrent(Graphics g){
        g.clearRect(x-streetWidth+2, y-streetWidth+2, streetWidth-4, streetWidth-4);
        g.fillRect(x-streetWidth+2, y-streetWidth+2, streetWidth-4, streetWidth-4);
    }

    private void drawPath(Graphics g) {
        
    }
    
    
    public class Desenho {
        
        int x;
        int y;
        
        public Desenho (int x, int y){
            this.x = x;
            this.y = y;
        }
       
    }
    
    public class Time extends Thread {
        
        public void run(){
            
            while(true){
                
                try {
                    //Thread.sleep(100);
                    Point point = getMousePosition();
                    desenhos.add(new Desenho(point.x, point.y));
                    repaint();
                } catch (Exception e) {
                }

            }
        }
    }
}  
