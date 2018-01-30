/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import com.sun.javafx.image.PixelSetter;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author heindani
 */
public class BombermanPanel extends Container {

    private static final long serialVersionUID = 4161752677750100437L;

    private static final ArrayList<activity> ACTIVITIES = new ArrayList<>();

    private Bomberman bomberman;

    public BombermanPanel(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void paint(Graphics g) {
        super.paint(g);
        ArrayList<GUIComponent> list = new ArrayList<>();
        for (int i = 60; i < bomberman.getWidth() - 16; i += 16) {
            for (int j = 0; j < bomberman.getHeight() - 32; j += 16) {
                if (i == 60 || j == 0 || j >= bomberman.getHeight() - 48 || i >= bomberman.getWidth() - 32) {

                    for (int k = 0; k < 11; k++) {
                        for (int l = 0; l <= 6; l++) {
                            GUIComponent gui2 = new GUIComponent(16, 16, new ImageIcon("/home/17ITAO2/heindani/NetBeansProjects/Bomberman/src/bomberman/pixelmauermitte.png").getImage(), 96 + 32 * k, 32 + 32 * l);
                            list.add(gui2);
                        }
                    }
                    for (int k = 0; k < 10; k++) {

                    }
                    GUIComponent gui = new GUIComponent(16, 16, new ImageIcon("/home/17ITAO2/heindani/NetBeansProjects/Bomberman/src/bomberman/mauergeil.png").getImage(), i, j);

                    gui.render((Graphics2D) g);

                    for (GUIComponent list1 : list) {
                        list1.render((Graphics2D) g);
                    }

                }

            }

        }

        bomberman.getThread().nowait();
    }

}
