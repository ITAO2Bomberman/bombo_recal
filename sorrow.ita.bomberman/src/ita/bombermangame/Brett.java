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
import java.util.Random;

/**
 *
 * @author ala_pascal
 */
public class Brett extends JPanel implements ActionListener {

    private final int B_WIDTH = 480;
    private final int B_HEIGHT = 272;
    private Timer timer;

    private final int[] xInner = {88, 120, 152, 184, 216, 248, 280, 312, 344, 376, 408};
    private final int[] yInner = {32, 64, 96, 128, 160, 192};
    private BreakableBlock[] breakableBlock;
    private Charakter c1;
    private Image outerWall;
    private Image innerWall;

    public Brett() {
        initBrett();
    }

    private void initBrett() {
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        setFocusable(true);

        c1 = new Trump(xInner, yInner);
        breakableBlock = getInnerLayout();
        outerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/mauergeil.png"));
        innerWall = loadImage(ita.bombermangame.Brett.class.getResource("sprites/mauer/pixelmauermitte.png"));
        randomBlocks();
        timer = new Timer(100, this);
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

    private void randomBlocks() {
        Random r1=new Random();
        for (BreakableBlock b : breakableBlock) {
            int r=r1.nextInt(20);
            System.out.println(r);
            if (r + 1 < 10) {
                b.zerbrechen();
            }
        }
    }

    private BreakableBlock[] getInnerLayout() {
        int[] x = {72, 88, 104, 120, 136, 152, 168, 184, 200, 216, 232, 248, 264, 280, 296, 312, 328, 344, 360, 376, 392, 408, 424};
        int[] y = {16, 32, 48, 64, 80, 96, 112, 128, 144, 160, 176, 192, 208};
        int c = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                for (int k = 0; k < xInner.length; k++) {
                    for (int l = 0; l < yInner.length; l++) {
                        if (!((x[i] == xInner[k] && y[j] == yInner[l]) || (x[i] == 72 && y[j] == 16) || (x[i] == 72 && y[j] == 32) || (x[i] == 88 && y[j] == 16))) {
                            c++;
                        }
                    }
                }
            }
        }
        BreakableBlock[] b = new BreakableBlock[c];
        c = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                for (int k = 0; k < xInner.length; k++) {
                    for (int l = 0; l < yInner.length; l++) {
                        if (!((x[i] == xInner[k] && y[j] == yInner[l]) || (x[i] == 72 && y[j] == 16) || (x[i] == 72 && y[j] == 32) || (x[i] == 88 && y[j] == 16))) {
                            b[c] = new BreakableBlock(x[i], y[j]);
                            c++;
                        }
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void paintComponent(Graphics g
    ) {
        super.paintComponent(g);
        paintBBlocks(g);
        paintWalls(g);
        paintChar(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void paintBBlocks(Graphics g) {
        for (BreakableBlock b : breakableBlock) {
            if (b.getVisibility() == true) {
                g.drawImage(b.getSprite(), b.getX()+2, b.getY(), this);
            }
        }
    }

    private void paintWalls(Graphics g) {
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
        c1.drawBomb(g);
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

    private void updateChar() {
        c1.move(breakableBlock);

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            c1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            c1.keyPressed(e);
//            checkCollision(e);
        }
    }
}
