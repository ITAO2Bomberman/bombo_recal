/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ala_pascal
 */
public class Brett extends JPanel implements ActionListener {

    private final int B_WIDTH = 480;
    private final int B_HEIGHT = 272;
    private Timer timer;
    private int explosion=0;
    
//    private final int[] xInner = {88, 120, 152, 184, 216, 248, 280, 312, 344, 376, 408};
//    private final int[] yInner = {32, 64, 96, 128, 160, 192};
    private Charakter c1;
    private Image outerWall;
    private Image innerWall;
    private boolean drop=false;
    
    public Brett() {
        initBrett();
    }

    private void initBrett() {
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        setFocusable(true);

        c1 = new Trump();

        outerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/mauergeil.png"));
        innerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/pixelmauermitte.png"));
        
        timer=new Timer(100, this);
        timer.start();
    }

    private Image loadImage(URL path) {
        ImageIcon ii = new ImageIcon(path);
        return ii.getImage();
    }

    private void drawImage(Graphics g, int x, int y, Image i) {
        g.drawImage(i, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private Coords[] walls() {
        int c = 0;
        for (int i = 60; i < B_WIDTH - 16; i += 16) {
            for (int j = 0; j < B_HEIGHT - 32; j += 16) {
                if (i == 60 || j == 0 || j >= B_HEIGHT - 48 || i >= B_WIDTH - 48) {
                    c++;
                }
            }
        }
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l <= 5; l++) {
                c++;
            }
        }
        Coords[] ret = new Coords[c];
        c = 0;
        for (int i = 60; i < B_WIDTH - 16; i += 16) {
            for (int j = 0; j < B_HEIGHT - 32; j += 16) {
                if (i == 60 || j == 0 || j >= B_HEIGHT - 48 || i >= B_WIDTH - 32) {
                    ret[c] = new Coords(i, j);
                    c++;
                }

            }
        }
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l <= 5; l++) {
                ret[c] = new Coords(90 + 32 * k, 32 + 32 * l);
                c++;
            }
        }
        return ret;
    }

    @Override
    public void paintComponent(Graphics g
    ) {
        super.paintComponent(g);
        paintWalls(g);
        paintChar(g);
        if(drop){
            c1.drawBomb(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void paintWalls(Graphics g){
        for (int i = 60; i < B_WIDTH - 16; i += 16) {
            for (int j = 0; j < B_HEIGHT - 32; j += 16) {
                if (i == 60 || j == 0 || j >= B_HEIGHT - 48 || i >= B_WIDTH - 48) {
                    drawImage(g, i, j, outerWall);
                }
            }
        }
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l <= 5; l++) {
                drawImage(g, 90 + 32 * k, 32 + 32 * l, innerWall);
            }
        }
    }
    
    private void paintChar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(c1.loadCharSprite(), c1.getX(), c1.getY(), this);
    }

//    public void checkCollision(KeyEvent e) {
//        int factorx = 0;
//        int factory = 0;
//        Rectangle r1 = c1.getBounds();
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_UP: {
//                factory = -16;
//                break;
//            }
//            case KeyEvent.VK_DOWN: {
//                factory = 16;
//                break;
//            }
//            case KeyEvent.VK_LEFT: {
//                factorx = -16;
//                break;
//            }
//            case KeyEvent.VK_RIGHT: {
//                factorx = 16;
//                break;
//            }
//            default: {
//                factorx = 0;
//                factory = 0;
//                break;
//            }
//        }
//        Boolean block = false;
//        for (int x : xInner) {
//            for (int y : yInner) {
//                if (x + factorx == r1.x && y + factory == r1.y) {
//                    block = true;
//                } 
//            }
//        }
//        if (block) {
//            c1.setMovable(false);
//        } else {
//            c1.setMovable(true);
//        }
//
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updateChar();
        repaint();
    }
    
    private void dropBomb(KeyEvent e){
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_SPACE || (explosion <= 20 && explosion !=0) ){
            drop=true;
            explosion++;
        }
        if(explosion>=20){
            explosion=0;
        }
    }
    
    private void updateChar(){
        c1.move();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            c1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            c1.keyPressed(e);
            dropBomb(e);
//            checkCollision(e);
        }
    }
}
