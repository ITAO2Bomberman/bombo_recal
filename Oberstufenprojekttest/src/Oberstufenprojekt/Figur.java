package Oberstufenprojekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.JPanel;


public class Figur extends JPanel{
    Variablen v1 = new Variablen();
    public Figur() {
   this.setPreferredSize(new Dimension(v1.getDimension_width(), v1.getDimension_height()));
        
    
    
    }
    public void setv(Variablen v){
        v1= v;
    }
    public void paintComponent(Graphics g){
        Spielfeld s = new Spielfeld(16, 16, v1);
        
        
        s.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(v1.getX_player1(), v1.getY_player1(), 16, 16);
        
    }   
}
