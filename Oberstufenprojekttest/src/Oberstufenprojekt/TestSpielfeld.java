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
public class TestSpielfeld extends JPanel {

    Variablen v = new Variablen();

    public TestSpielfeld() {
        this.setPreferredSize(new Dimension(v.getDimension_width(), v.getDimension_height()));

    }

    public void paintComponent(Graphics g) {
        int[][] abfrage = v.getHindernisse();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < abfrage.length; k++) {
                    if (i * 10 == abfrage[k][0] && j * 10 == abfrage[k][1]) {
                        System.out.println("Kollisionsfeld");
                        if (abfrage[k][2] == 1) {
                            g.setColor(Color.red);
                      
                        } else {
                            if (abfrage[k][2] == 2) {
                                g.setColor(Color.blue);
                               
                            } else {
                                 if (abfrage[k][2] == 3) {
                            g.setColor(Color.PINK);
                   
                            }

                        }
                    }}
                    else {
                        if (g.getColor() == Color.BLACK) {
                            g.setColor(Color.CYAN);
                        }
                    }
                }

                g.fillRect(10 * j, 10 * i, 10, 10);
                g.setColor(Color.black);
                g.drawRect(10 * j, i * 10, 10, 10);

            }

        }
    }

}
