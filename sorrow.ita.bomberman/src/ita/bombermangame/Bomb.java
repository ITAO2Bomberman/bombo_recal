/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ita.bombermangame;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author ala_pascal
 */
public class Bomb {
    private Image bombSprite;
    private final int x,y;
    private int time=0;
    private boolean vis=true;
    
    public Bomb(URL bombURL,int x, int y){
        this.x=x;
        this.y=y;
        bombSprite=new ImageIcon(bombURL).getImage();
    }
    
    public Image getBombSprite(){
        return bombSprite;
    }
    
    public void explode(){
        if(time == 10){
            vis=false;
            
        }else{
            time++;
        }
    }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean getVis(){
        return vis;
    }
}
