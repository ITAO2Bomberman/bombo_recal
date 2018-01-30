/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author heindani
 */
class GUIComponent {
    
    private int x, y, width, height;
    private Color background, borderColor;
    private boolean border;
    private Image img;
    
    public GUIComponent(int width, int heigth, Image img, int x,int y)
    {
        this(x, y, width, heigth);
        this.img=img;
    }

    
    public GUIComponent(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getBackground() {
        return background;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public boolean isBorder() {
        return border;
    }

    void render(Graphics2D g) {
        if(!border){
        g.drawImage(img, x, y, null);
        
    }else{
        }
    }
    
}
