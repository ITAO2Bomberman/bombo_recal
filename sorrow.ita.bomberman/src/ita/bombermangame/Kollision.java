/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

/**
 *
 * @author ala_pascal
 */
public class Kollision {
    public static boolean Kollisionsberechnung(int x, int y, int[][] obstacle) {
        for (int i = 0; i < obstacle.length; i++) {
            if (obstacle[i][0] == x && obstacle[i][1] == y || x < 0 || y < 0 || x > 480 - 16 || y > 272 - 16) {
                System.out.println("Kollision");
                return true;

            } else {

            }
        }
        return false;
    }
}
