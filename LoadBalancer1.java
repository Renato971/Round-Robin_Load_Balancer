/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dushk
 */
public class LoadBalancer1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server();/*conects the server to the load balancer*/
        Thread sThread = new Thread(s);/*creates a thread*/
        sThread.start();/*thread starts*/
    }
    
}