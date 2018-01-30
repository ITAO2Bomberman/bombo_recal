package bomberman;

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
  
     
}
