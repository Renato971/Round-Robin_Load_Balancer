/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer1;

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
 * @author dushk
 */
public class Node1 {
        //data
    private InetAddress nodeIPAddress;/*sets the IP address as a private value*/
    private int nodePort;/*private integer for the port of the node*/
    private String nodeName;/*private string for the node name*/
    private int maxJobs;/*private integer for the max amount of jobs*/
    private int currentJobs;/*private integer for the current job*/
    
    //methods
    
    public Node1(InetAddress IP, int port, String name, int max){ /*sets class
        "Node1" as public with the parameters inside the brackets*/
        
        /*giving the arguments a value*/
        nodeIPAddress=IP;
        nodePort=port;
        nodeName=name;
        maxJobs = max;
        currentJobs=0;
    }
    /*end of above code section*/
    
    //set methods
    public void setNodePort(int newPort) {
        nodePort= newPort;/*sents new value*/
        System.out.println("Port number is: " + newPort);/*prints the value of the port number*/
        
    }
    
    public void setNodeName (String newName) {
        nodeName = newName;/*sets a new value*/
        if (newName != null) {/*if the node name is inequal to nothing (therefore its soemthing)....*/
            System.out.println("Node Name: " + newName);/*This will be displayed*/
        } else {/*if above is not met then.....*/
            System.out.println("Node Name Not Found!!");/*This will be printed*/
        }
    }
    
    public void setMaxJobs (int maxNum) {
        maxJobs = maxNum;/*sets a new value for the argument*/
        maxNum = 8;/*sets a value for the variable*/
        
    }
    
    public void setCurrentJobs (int currentJob) {
        currentJobs = currentJob;/*new value for argument*/
                
    }
    
    //get methods
    
    public InetAddress getNodeAddress(){
        return nodeIPAddress;/*this request will return the IP address f the node*/
    }
    
    public int getNodePort() {
        return nodePort;/*node port number will be returned*/
    }
    
    public String getNodeName() {
        return nodeName;/*node name will be returned*/
    }
    
    public int getMaxJobs () {
        return maxJobs;/*return max number of jobs*/
    }
    
    public int getCurrentJobs() {
        return currentJobs;/*return the current jobs*/
    }
    
    //normal methods
    public float calculateWeight() {
        
        return 0;/*retun 0*/
    }
    
    public void sendMessage(String message) {
        try {
            DatagramSocket sock = new DatagramSocket(1766);/*sock= the socket. creates a new 
            Datagram socket with a port number*/
            sock.send(new DatagramPacket(message.getBytes(), message.getBytes().length, nodeIPAddress, nodePort));/*sends a socket
            by creating a new datagram socket with the following arguments- getting the message bytes, the length of the bytes,
            the ip address of the node and the port of the node*/
            sock.close();/*close the socket*/
            
            /*Error checking*/
        } catch (SocketException ex) {
            Logger.getLogger(Node1.class.getName()).log(Level.SEVERE, null, ex);/*Logger= provides the ability to 
            trace out the errors of the applications. */
        } catch (IOException ex) {
            Logger.getLogger(Node1.class.getName()).log(Level.SEVERE, null, ex);/*SEVERE= the given message is forwarded 
            to all the registered output Handler objects*/
        }
    }

        
    
}
