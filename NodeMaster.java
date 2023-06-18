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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shala
 */
public class NodeMaster {
        //data
    private InetAddress nodeIPAddress;
    private int nodePort;
    private String nodeName;
    private int maxJobs;
    private int currentJobs;
    
    //methods
    
    public NodeMaster(InetAddress IP, int port, String name, int max){
        nodeIPAddress=IP;
        nodePort=port;
        nodeName=name;
        maxJobs = max;
        currentJobs=0;
    }
    
    //set methods
    public void setNodePort(int newPort) {
        nodePort= newPort;
         if (newPort != 0) {
            System.out.println("New Node port found: " + newPort);
        } else {
            System.out.println("Node port Not Found!!");
        }
     
    }
    
    public void setNodeName (String newName) {
        // something goes here
        nodeName = newName;
        if (newName != null) {
            System.out.println("Node Name: " + newName);
        } else {
            System.out.println("Node Name Not Found!!");
        }
    }
    
    public void setMaxJobs (int newmaxJobs) {
         maxJobs = newmaxJobs;
          if (newmaxJobs != 0) {
            System.out.println("new Max jobs located: " + newmaxJobs);
        } else {
            System.out.println("new max jobs not located!");
        }
         
       
        // something goes here
    }
    
    public void setCurrentJobs (int newcurrentJob) {
        currentJobs = newcurrentJob;
         if (newcurrentJob != 0) {
            System.out.println("Current new Jobs locted  : " + newcurrentJob);
        } else {
            System.out.println("new current Jobs unlocated/missing");
        } 
        // something goes here
        
    }
    
    //get methods
    
    public InetAddress getNodeAddress(){
        return nodeIPAddress;
    }
    
    public int getNodePort() {
        return nodePort;
    }
    
    public String getNodeName() {
        return nodeName;
    }
    
    public int getMaxJobs () {
        return maxJobs;
    }
    
    public int getCurrentJobs() {
        return currentJobs;
    }
    
    //normal methods
    public float calculateWeight() {
        //code goes here
        return currentJobs/maxJobs;
    }
    
    public void sendMessage(String message) {
        try {
            DatagramSocket sock = new DatagramSocket(1766);
            sock.send(new DatagramPacket(message.getBytes(), message.getBytes().length, nodeIPAddress, nodePort));
            sock.close();
        } catch (SocketException ex) {
            Logger.getLogger(NodeMaster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NodeMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
