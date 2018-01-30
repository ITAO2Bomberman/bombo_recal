/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oberstufenprojekt;

/**
 *
 * @author MichaL
 */
public class Variablen {
    private int x_player1 = 32;
    private int y_player1 = 32;
    private int Dimension_width = 16*16;
    private int Dimension_height = 16*17;
    private int[][] Hindernisse = {{32,64,1},{32,96,2},{32,128,3}} ;

    public int[][] getSpielfeld() {
        return Spielfeld;
    }

    public void setSpielfeld(int[][] Spielfeld) {
        this.Spielfeld = Spielfeld;
    }
   
    private int[][] Spielfeld;

    public int[][] getHindernisse() {
        return Hindernisse;
    }

    public int getDimension_width() {
        return Dimension_width;
    }

    public int getDimension_height() {
        return Dimension_height;
    }
    public int getX_player1() {
        return x_player1;
    }

    public void setX_player1(int x_player1) {
        this.x_player1 = x_player1;
    }

    public int getY_player1() {
        return y_player1;
    }

    public void setY_player1(int y_player1) {
        this.y_player1 = y_player1;
    }
    
    
}
