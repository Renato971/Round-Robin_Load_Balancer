/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dushk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
            int port = Integer.parseInt(args[0]);/*parses argument 0*/
            InetAddress addr = InetAddress.getByName(args[1]);/*gets the IP address by name on arg 1*/
            
            DatagramSocket sock = new DatagramSocket(Integer.parseInt(args[2]), InetAddress.getByName(args[1]));/*sets port 
            number to 6000 and the IP*/ 
            
            LoadBalancer lb = new LoadBalancer(port, addr);/*connects to loadbalancer from nodes
            and creates a new arguments with inbuild elements*/
            Node thisNode = new Node(0/*current job*/, 10/*max jobs*/, args[3]);/*sets node name as "Nodeee"*/
            
            String message = "REG/" + thisNode.getName() + "/" + thisNode.getMaxLoad();/*registration message*/
            DatagramPacket dPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, lb.lbIP, lb.port);
            
            sock.send(dPacket);/*sends socket packet*/
            
            while (true) {
                byte[] data = new byte[1024];/*gets only 1024 bytes out of the data*/
                DatagramPacket packet;
                packet = new DatagramPacket(data, data.length);/*data length*/
                
                
                sock.receive(packet);
                
                String recvMsg = new String(data);/*string message for the message received which contains the data*/
                String[] splitRecvMsg = recvMsg.trim().split("/");/*splits the message*/
                System.out.println(Arrays.toString(splitRecvMsg));/*prints the array in a string format*/
                
                switch (splitRecvMsg[0]) {
                    /*creates a job message*/
                    case "JOB": {
                        Thread jobT = new Thread(new jobThread(Integer.parseInt(splitRecvMsg[2]), splitRecvMsg[1]));
                        jobT.start();
                        break;
                    }/*Job created----------------------------------------*/
                }
            }
            /*error catching*/
            /*unknown host error checking*/
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            /*-------------------------------------------*/
            /*if port number is not an integer error checking*/
        } catch (NumberFormatException e) {
            System.out.println("Bad port.");
            System.exit(0);
            /*--------------------------------------------------------*/
            /*socket error checking*/
        } catch (SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            /*-------------------------------------------*/
            /*Input/ Output error checking*/
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }/*------------------------------------------------------------*/
        
        /*---------------------------------------------------------------*/
    }
    
}
