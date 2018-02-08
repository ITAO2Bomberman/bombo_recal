/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author MichaL
 */
public class randomfield {
    protected final int[] xInner = {88, 120, 152, 184, 216, 248, 280, 312, 344, 376, 408};
    protected final int[] yInner = {32, 64, 96, 128, 160, 192};
    public void paintComponent(Graphics g){
    }
    public void erzeugeRandomfield(){
        Random r = new Random();
        boolean run = false;
        int q = r.nextInt(277);
        int[][] w = new int[q][2];
        int e;
        int t;
        for (int i = 0; i < w.length; i++) {
            while(run == false){
                e = r.nextInt(23);
                t = r.nextInt(13);
                
            }
        }
    }
}
