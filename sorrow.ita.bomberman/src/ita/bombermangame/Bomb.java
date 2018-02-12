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
    private boolean bvis=false;
    private Image exSprite;
    
    public Bomb(URL explodeicon, URL bombURL,int x, int y){
        this.x=x;
        this.y=y;
        bombSprite=new ImageIcon(bombURL).getImage();
        exSprite = new ImageIcon(explodeicon).getImage();
        exSprite=exSprite.getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING);
    }
    
    public Image getBombSprite(){
        return bombSprite;
    }
    
    public Image getexplodesprite(){
        return exSprite;
    }
    
    public void explode(BreakableBlock[] b){
        if(time >= 10){
            vis=false;
            for (int i = 0; i < b.length; i++) {
                if(x+16 == b[i].getX() && y ==b[i].getY() || y+16 == b[i].getY() && x ==b[i].getX() ||x-16 == b[i].getX() && y ==b[i].getY() || y-16 == b[i].getY() && x ==b[i].getX()){
                    b[i].zerbrechen();
                    
                }
            }
             
           
            
        }else{
            time++;
        }
        if(vis==false)
        seeexplodeSprite();
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

    public boolean getBvis() {
        return bvis;
    }
    
    public void seeexplodeSprite(){
        bvis = true;
        
        if (time >= 13) {
            bvis = false;
        }
        else{
        System.out.println(time);
        time++;
        }
        
        
    } 
}
