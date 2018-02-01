/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;
/**
 *
 * @author ala_pascal
 */
abstract class Charakter {
    
    private int dx,dy,x,y;
    private Image sprite;
    private URL[] charURL;
    
    abstract void initChar();
    
    abstract URL[] charSprites();
    
    abstract Image loadCharSprite();
    
    abstract void move();
    
    abstract int getX();
    
    abstract int getY();
    
    abstract void keyPressed(KeyEvent e);
    
    abstract void keyReleased(KeyEvent e);
}
