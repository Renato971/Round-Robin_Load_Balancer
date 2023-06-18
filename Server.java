/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancermaster;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shala
 */
public class Server extends Thread {
    
    int port;
    InetAddress addr;
    NodeManager nodeMgr;
    
    
    public Server() {
        this.nodeMgr = new NodeManager();
    }
    
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(5000, InetAddress.getByName("192.168.1.68"));
            socket.setSoTimeout(0);
            
            boolean server = true;
            while (server) {
                byte[] packetData = new byte[1024];
                DatagramPacket packet = new DatagramPacket(packetData, packetData.length);
                
                socket.receive(packet);
                String message = new String(packetData);
                System.out.println("Got Data: " + message);
                
                String[] cmds = message.trim().split("/");
                
                switch (cmds[0]) {
                    case "REG": {
                        nodeMgr.addNode(cmds[1], packet.getAddress(), packet.getPort(), Integer.parseInt(cmds[2]));
                        break;
                    }
                    case "JOB": {
                        int jobSize = Integer.parseInt(cmds[1]);
                        String jobName = cmds[2];
                        
                        System.out.println("Got Job: " + jobName + " " + jobSize);
                        System.out.println("----------------> Getting job message");
                        NodeMaster node = nodeMgr.getNextNode();
                        System.out.println(node.getNodeName() + " " + node.getNodeAddress() + " " + node.getNodePort());
                        node.sendMessage("JOB/" + jobName + "/" + jobSize);
                      
                        break;
                    }
                     case "FINISHED":
                    // this is a finished
                        System.out.println("----> got a FINISH instruction");
                        break;
                    case "Stop":
                        System.out.println("----> got a STOP instruction");
                        server = false;
                        break;
                  
     
                }
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(LoadBalancerFirst.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(LoadBalancerFirst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
