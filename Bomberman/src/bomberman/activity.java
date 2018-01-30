/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;


import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;


/**
 *
 * @author heindani
 */
public class activity {
    
    private boolean loaded;
    protected boolean loadsync, finish;// brauchen die variablen um zu gucken ob das bild lädt oder geladen ist
    private ArrayList<GUIComponent> components = new ArrayList<>();
            
            
    public final  void load()
    {
       loaded = false;
       if(loadsync){
           
           new Thread()
           {
           @Override
           public void run()
           {
            onLoad();
            loaded = true;
           };
           }.start();
       
       }else{
       onLoad();
       loaded = true;
       }
    }
    
    public boolean isLoaded()
    {
        return loaded;
    }
    
    public boolean isFinish()
    {
        return finish;
    }

    protected void onLoad() {}
    
    public void update(){}
    
    public void render (Graphics2D g)
    {
        for(GUIComponent component : components)
        {
            component.render(g);
        }
    }
}

