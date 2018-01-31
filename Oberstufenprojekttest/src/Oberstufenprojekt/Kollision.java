/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oberstufenprojekt;

/**
 *
 * @author MichaL


*/
public class Kollision {
    int[][][] spielfeld;

    public Kollision(int[][][] spielfeld) {
        this.spielfeld = spielfeld;
    }
    
    public boolean Kollisionsberechnung(int x, int y, int[][] eisberg){
        Variablen v = new Variablen();
        for (int i = 0; i < eisberg.length; i++) {
            if (eisberg[i][0] == x && eisberg[i][1] == y || x < 16 || y < 32 || x> v.getDimension_width()-32 || y>v.getDimension_height()-32) {
                System.out.println("Kollision");
                return true;
                
            }
            else{
            
            }
        }
        return false;
    }

public boolean Kollisionsberechnung(int x, int y){
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[0].length; j++) {
                if(spielfeld[j][i][0] == x && spielfeld[j][i][1] == y){
                    if (spielfeld[j][i][2] == 0) {
                      return true;  
                    }
                    else{
                    
                    }
                }
            }
    }
    return false;
    
}
}
