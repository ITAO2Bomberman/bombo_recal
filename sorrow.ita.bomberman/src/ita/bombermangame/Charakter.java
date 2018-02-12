/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author ala_pascal
 */
public abstract class Charakter {

    protected ArrayList<Bomb> bomben = new ArrayList<>();
    protected int dx, dy, x, y, width, heigth;
    protected int bx, by;
    protected URL[] charURL;
    protected URL bombURL;
    protected URL explodeicon;
    protected boolean mov = true;
    protected int key = KeyEvent.VK_DOWN;
    protected final int[] xInner;
    protected final int[] yInner;
    protected BreakableBlock[] block;

    public Charakter(int[] xInner,int[] yInner ,BreakableBlock[] block){
        this.xInner=xInner;
        this.yInner=yInner;
        this.block = block;
        
    }
    
    protected abstract URL loadexplode();
    
    public abstract void initChar();

    protected abstract URL bombSprite();

    protected abstract URL[] charSprites();

    public void drawBomb(Graphics g) {
        bomben.stream().filter((b) -> ((b.getVis()==true && b.getBvis()==true) || (b.getBvis()==true && b.getVis()==false) || (b.getBvis()==false && b.getVis()==true))).map((b) -> {
            if (b.getVis() == true) {
                
            
            g.drawImage(b.getBombSprite(), b.getX(), b.getY(), null);
            }
            return b;
            
        }).forEach((b) -> {
            boolean up = false;
            boolean down = false;
            boolean left = false;
            boolean right = false;            
            b.explode(block);
            if(b.getBvis() == true){
                for (int i = 0; i < yInner.length; i++) {
                    for (int j = 0; j < xInner.length; j++) {
                        if (yInner[i] == b.getY()-16 && xInner[j] == b.getX()) {
                            up = true;
                        }
                        if (yInner[i] == b.getY()+16 && xInner[j] == b.getX()) {
                            down = true;
                        }
                        if (yInner[i] == b.getY() && xInner[j]-16 == b.getX()) {
                            left = true;
                        }
                        if (yInner[i] == b.getY() && xInner[j]+16 == b.getX()) {
                            right = true;
                        }
                   
 
                    }
                }
            g.drawImage(b.getexplodesprite(), b.getX(), b.getY(), null);
                
            //left
            if(left == false){
            g.drawImage(b.getexplodesprite(), b.getX()-16, b.getY(), null);
            }
//right
                if (right == false) {
            g.drawImage(b.getexplodesprite(), b.getX()+16, b.getY(), null);
                }//down
                if (up == false) {
            g.drawImage(b.getexplodesprite(), b.getX(), b.getY()-16, null);
                }//up
                if(down == false){
            g.drawImage(b.getexplodesprite(), b.getX(), b.getY()+16, null);
            }
            }
        });
    }

    public Image loadCharSprite() {
        switch (key) {
            case KeyEvent.VK_LEFT: {
                return new ImageIcon(charURL[1]).getImage();
            }
            case KeyEvent.VK_RIGHT: {
                return new ImageIcon(charURL[2]).getImage();
            }
            case KeyEvent.VK_UP: {
                return new ImageIcon(charURL[3]).getImage();
            }
            case KeyEvent.VK_DOWN: {
                return new ImageIcon(charURL[0]).getImage();
            }
        }
        return new ImageIcon(charURL[0]).getImage();
    }

    public abstract void move(BreakableBlock[] breakable);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMovable(Boolean mov) {
        this.mov = mov;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, heigth);
    }

    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -16;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 16;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -16;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 16;
        }

        if (key == KeyEvent.VK_SPACE) {
            
            bomben.add(new Bomb(explodeicon,bombURL, x, y));
        }
    }

    public void keyReleased(KeyEvent e) {
     key = e.getKeyCode();

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
