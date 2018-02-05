/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.event.KeyEvent;
import java.net.URL;

/**
 *
 * @author ala_pascal
 */
public class Trump extends Charakter {

    public Trump() {
        initChar();
        super.charURL = charSprites();
    }

    @Override
    public void initChar() {
        charURL = charSprites();
        super.x = 72;
        super.y = 16;
        super.heigth = 16;
        super.width = 16;
    }

    @Override
    protected URL[] charSprites() {
        URL[] re = new URL[4];
        for (int i = 0; i < 4; i++) {
            re[i] = Trump.class.getResource("sprites/trump/" + (i + 1) + ".png");
        }
        return re;
    }

    @Override
    public void move() {
        if (!mov) {
        } else {
            boolean wall = false;
            for (int xw : super.xInner) {
                for (int yw : super.yInner) {
                    if (xw == super.x + super.dx && yw == super.y + super.dy) {
                        wall = true;
                    }
                }
            }
            if (wall == false) {
                super.y += super.dy;
                super.x += super.dx;
            }
            if (super.x < 72) {
                super.x = 72;
            }
            if (super.y < 16) {
                super.y = 16;
            }
            if (super.x > 424) {
                super.x = 424;
            }
            if (super.y > 208) {
                super.y = 208;
            }
            System.out.println("x " + super.x + " y " + super.y);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            super.dx = -16;
        }

        if (key == KeyEvent.VK_RIGHT) {
            super.dx = 16;
        }

        if (key == KeyEvent.VK_UP) {
            super.dy = -16;
        }

        if (key == KeyEvent.VK_DOWN) {
            super.dy = 16;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            super.dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            super.dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            super.dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            super.dy = 0;
        }
    }

}
