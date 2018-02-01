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
    private final int DELAY = 25;

    private Charakter c1;
    private Image outerWall;
    private Image innerWall;
    private Timer timer;

    public Brett() {
        initBrett();
    }

    private void initBrett() {
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        setFocusable(true);

        c1=new Trump();
        
        outerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/mauergeil.png"));
        innerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/pixelmauermitte.png"));
    }

    private Image loadImage(URL path) {
        ImageIcon ii = new ImageIcon(path);
        return ii.getImage();
    }

    private void drawImage(Graphics g, int x, int y, Image i) {
        g.drawImage(i, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 60; i < B_WIDTH - 16; i += 16) {
            for (int j = 0; j < B_HEIGHT - 32; j += 16) {
                if (i == 60 || j == 0 || j >= B_HEIGHT - 48 || i >= B_WIDTH - 32) {
                    drawImage(g, i, j, outerWall);
                }
            }
        }
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l <= 5; l++) {
                drawImage(g, 96 + 32 * k, 32 + 32 * l, innerWall);
            }
        }
        paintChar(g);
    }
    
    private void paintChar(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(c1.loadCharSprite(), c1.getX(), c1.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c1.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e){
            c1.keyReleased(e);
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            c1.keyPressed(e);
        }
    }
}
