/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author ala_pascal
 */
public class App extends JFrame {

    public App() {
        initApp();
    }

    private void initApp() {
        add(new Brett());

        setSize(480, 272);

        setTitle("Bomberman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
    }
}