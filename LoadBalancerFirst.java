/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancermaster;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
// the imports that i have added here arent really neccerary because i didnt add any try,catch statments that can catch any error for sockets, datapacket or inetaddress, Error e however still good to have//
/**
 *
 * @author Shala
 */
public class LoadBalancerFirst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // public static ensure that methods are being called and executed from the main//
        
  // threading is being used to allow multiple node to run
        Server s = new Server();
        Thread sThread = new Thread(s);
        sThread.start();
        // Server s is jsut a varaible to start a simp,e thread, and the new starts a new thread//
        // However what really starts the threat is the sThread.start() this type of thread is called from the arguments because there is another type of thread that can be done from a class//
        // sthread is being used at the start because it was declared above at the "new Thread(s)" so i have to use that, plus s was declared even ealier where Server was delcared i ensured that the server was being included//
    }
    
}