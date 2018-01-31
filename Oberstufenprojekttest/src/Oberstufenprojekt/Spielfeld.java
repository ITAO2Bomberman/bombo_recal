/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oberstufenprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author MichaL
 */
public class Spielfeld extends JPanel {

    private int x;
    private int y;
    Variablen v = new Variablen();

    public Spielfeld(int breite, int hoehe, Variablen va) {
        x = breite;
        y = hoehe;
        va = v;
        int[][] feld =  new int[hoehe][breite];
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                feld[i][j] = 0;
            }
        }
        for (int i = 0; i < feld[0].length; i++) {
            feld[0][i] = 1;
            feld[feld.length-1][i]=1;
            
        }
        for (int i = 0; i < feld.length; i++) {
            feld[i][0] = 1;
            feld[i][feld[i].length-1] = 1;
        }
        v.setSpielfeldnormal(feld);
    }

    public void paintComponent(Graphics g) {
        int[][] p = v.getSpielfeldnormal();
        int[][][] c = new int[p.length][p[0].length][3];
        int breakable = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                breakable = 0;
                if (p[i][j] == 1) {
                    g.setColor(Color.red);
                    breakable = 1;
                }
                else{
                g.setColor(Color.blue);
            }
                g.fillRect(j * 16, 16 + i * 16, 16, 16);
                g.setColor(Color.black);
                g.drawRect(j * 16, 16 + i * 16, 16, 16);
                System.out.println(i*16 + " " + j*16);
                c[i][j][0]=j*16;
                c[i][j][1]=i*16;
                c[i][j][2]=breakable;
              
            }
        }
        v.setSpielfeld(c);
        
    }
}
