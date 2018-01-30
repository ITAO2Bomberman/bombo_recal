/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

/**
 *
 * @author MichaL
 */
public class Kollision {
    public boolean Kollisionsberechnung(int x, int y, int[][] eisberg){
        GUIComponent component = new Variablen();
        for (int i = 0; i < eisberg.length; i++) {
            if (eisberg[i][0] == x && eisberg[i][1] == y || x < 0 || y < 0 || x> component.getWidth()-10 || y>component.getHeight()-10) {
                System.out.println("Kollision");
                return true;
                
            }
            else{
            
            }
        }
        return false;
    }
}
