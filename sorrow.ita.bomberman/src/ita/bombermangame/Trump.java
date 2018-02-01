/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author ala_pascal
 */
public class Trump extends Charakter {
    private int dx,dy,x,y;
    private Image sprite;
    private URL[] charURL;
    private int key=KeyEvent.VK_DOWN;
    
    public Trump(){
        initChar();
    }
    
    @Override
    void initChar() {
        charURL=charSprites();
        sprite=loadCharSprite();
        x=72;
        y=16;
    }

    @Override
    URL[] charSprites() {
        URL[] re=new URL[4];
        for(int i =0;i<4;i++){
            re[i]=Trump.class.getResource("sprites/trump/"+(i+1)+".png");
        }
        return re;
    }

    @Override
    Image loadCharSprite() {
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
        return null;
    }

    @Override
    void move() {
        y+=dy;
        x+=dx;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    @Override
    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
}
