/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.net.URL;

/**
 *
 * @author ala_pascal
 */
public class Trump extends Charakter {

    public Trump(int[] xInner, int[] yInner) {
        super(xInner, yInner);
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
        super.bombURL=bombSprite();
    }

    @Override
    protected URL bombSprite() {
        return Trump.class.getResource("sprites/bombs/bombAmi.png");
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
    public void move(BreakableBlock[] breakable) {
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

}
