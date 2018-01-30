/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import javax.swing.JFrame;

/**
 *
 * @author heindani
 */
public class Bomberman {
    
    private static final int WIDTH = 480, HEIGHT = 272;
    
    private JFrame frame;
    private BombermanPanel panel;
    private BombermanThread thread;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
      new Bomberman();
    }
    
    public Bomberman()
    {
      frame = new JFrame("Bomberman"); // ertstellt einen neuen Frame namens Bomberman
      frame.setSize(WIDTH, HEIGHT); // setzt eine höhe und breite
      frame.setLocationRelativeTo(null); // setzt die postion des fensters relativ zu dem eines anderen Fensters
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// wenn das programm geschloßen wird , wird es auch beendet
      frame.setResizable(true); // verhindert dass das Fenster nicht vergrößert oder verkleinert werden kann
      frame.setVisible(true);// setzt das Fenster für den nutzer sichtbar
      
      panel = new BombermanPanel(this); // wir sagen das Panel einen neuen Bombermanpanel kriegt
      frame.setContentPane(panel); // Legt die contentPane Eigenschaft fest
      
      thread = new BombermanThread(panel);
      thread.start();
        
    }
    
    public JFrame getFrame()
    {
        return frame;
    }

    public BombermanThread getThread() {
        return thread;
    }
    
    public int getWidth(){
        return WIDTH;
    }
    
    public int getHeight(){
        return HEIGHT;
    }
}
