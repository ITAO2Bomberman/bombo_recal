/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author ala_pascal
 */
public abstract class Charakter {
    
    protected int dx,dy,x,y, width, heigth;
    protected URL[] charURL;
    protected URL bombURL;
    protected boolean mov=true;
    protected int key=KeyEvent.VK_DOWN;
    protected final int[] xInner = {88, 120, 152, 184, 216, 248, 280, 312, 344, 376, 408};
    protected final int[] yInner = {32, 64, 96, 128, 160, 192};
    
    public abstract void initChar();
    
    protected abstract URL bombSprite();
    
    protected abstract URL[] charSprites();
    
    public Image loadBombSprite(){
        return new ImageIcon(bombURL).getImage();
    }
    
    public Image loadCharSprite(){
        switch(key){
            case KeyEvent.VK_LEFT:{
                return new ImageIcon(charURL[1]).getImage();
            }
            case KeyEvent.VK_RIGHT:{
                return new ImageIcon(charURL[2]).getImage();
            }
            case KeyEvent.VK_UP:{
                return new ImageIcon(charURL[3]).getImage();
            }
            case KeyEvent.VK_DOWN:{
                return new ImageIcon(charURL[0]).getImage();
            }
        }
        return new ImageIcon(charURL[0]).getImage();
    }
    
    public abstract void move();
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setMovable(Boolean mov){
        this.mov=mov;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, heigth);
    }
    
    public abstract void keyPressed(KeyEvent e);
    
    public abstract void keyReleased(KeyEvent e);
}
