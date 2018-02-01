/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oberstufenprojekt;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author MichaL
 */
public class Bombe extends JPanel{
    private Variablen v1 = new Variablen();
    public void paintComponent(Graphics g){
     int[][] list;
     
    }
    public int[][] addbomb(Variablen v){
        int[][] listalt= v.getBomben();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <listalt.length; i++) {
            list.add(listalt[i]);
        }
        int[] i = {v.getX_player1(), v.getY_player1()};
        list.add(i);
        return (int[][]) list.toArray();
    } 

    public Variablen getV() {
        return v1;
    }

    public void setV(Variablen v) {
        this.v1 = v;
    }
    
    
}
