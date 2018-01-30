/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

/**
 *
 * @author heindani
 */
public class BombermanThread extends Thread{
    
    private long MIN_FRAME_DURATUION = 1000000000 / 31;// damit können wir bestimmen wie viel fps wir wollen. Die erste Zahl sind die NanoSekunden durch die Anzahl der gewünschten Frames. Damit sagt aus wie lange da Bild braucht um zu laden.

    private BombermanPanel panel;
    private long passedFrameTime, lastFrameTime, delta; //
    private int framePerSecond;
    
    public BombermanThread(BombermanPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public  synchronized void run() {
        while(true){
        try {
            lastFrameTime = System.nanoTime(); // ruft das programm in einer nano sekunde ab 
           panel.repaint(); // damit rendern wir unser Panel
            this.wait();
            
            delta = System.nanoTime() - lastFrameTime;
            framePerSecond ++;
            passedFrameTime += delta;
            
            if(passedFrameTime > 1000000000)
            {
                System.out.println(framePerSecond);
                framePerSecond = 0;
                passedFrameTime = 0;
            }
            
            if(delta < MIN_FRAME_DURATUION)
            {
                long stop = MIN_FRAME_DURATUION - delta;
                long milli = stop /1000000; // damit kriegen wir die genauen millisekunden an 
                int nano = (int)(stop - milli *1000000);
                Thread.sleep(milli, nano);
                passedFrameTime += stop;
            }
                    
        }catch (Exception e){
            e.printStackTrace();
        }
        
            
        }
    }
    
    public void nowait()
    {
       synchronized(this)
       
       {
           this.notify();
       }
               
    }
}
