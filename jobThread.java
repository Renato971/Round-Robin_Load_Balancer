/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dushk
 */
public class jobThread extends Thread {
    
    private int Size;
    private String ID;
    
    public jobThread (int size, String id) {
        this.Size = size;
        this.ID = id;
    }
    
    /*Job thread, can send multiple jobs simultanuesley*/
    public void run() {
        int i = 0;/*i is 0*/
        while (i <= Size) {/*while i is maller than/ equal to size.....*/
            try {
                Thread.sleep(1000);/*thread stops in 1000 milliseconds*/
                i ++;/*i is added by 1*/
                /*interuption error catcher*/
            } catch (InterruptedException ex) {
                Logger.getLogger(jobThread.class.getName()).log(Level.SEVERE, null, ex);
            }/*--------------------------------------*/
        }
        System.out.println("JOB Complete: " + ID + ", Size: " + Size);/*if successful print this*/
    }/*-------------------------------------------*/
}
