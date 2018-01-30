/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oberstufenprojekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author MichaL
 */
public class TestFeld extends JPanel{
    int[][] positionen;
    Variablen v = new Variablen();
    
    public TestFeld(){
            
          this.setPreferredSize(new Dimension(v.getDimension_width(), v.getDimension_height()));
        positionen = v.getHindernisse();
        
    }
    public void setv(Variablen v1){
        this.v = v1;
    }
    @Override
    public void paintComponent(Graphics g){
        for (int i = 0; i < positionen.length; i++) {
            g.setColor(Color.red);
            g.fillRect(positionen[i][0], positionen[i][1], 10, 10);
        }
    }
}
