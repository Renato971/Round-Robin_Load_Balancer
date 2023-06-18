/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dushk
 */
public class Initiator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        // Get arguments.
        
        if(args == null || args.length < 4) { /*if the arguments are nothing or the argument length is lower than 4 then the code will run the 
            below section*/
            System.out.println("Invalid Arguments supplied."); /*this message will print if the argument does not meet the requirements*/
            System.exit(0); /*system/ code will stop running and exit (not display anything else of the code*/
        }
        
        try {
            
            int port = Integer.parseInt(args[1]); /*the integer variable "port" gets the argument from the args list */
            
            if (port > 65565 || port <= 0){ /*if port is bigger than 65565 or smaller than or equal to 0 then....*/
                System.out.println("Port out of range.");/* This will be printed*/ 
                System.exit(0); /*system/ code will stop running and exit (not display anything else of the code*/
            }
            
            InetAddress addr = InetAddress.getByName(args[0]); /*This gets the IP address from the arguments
            the argument "0" is extracted which is the very first one on the arguments list*/
            
            Scanner scn = new Scanner (System.in); /*scanner= usd to get user imput. This is then created into a variable
            called "scn" which created a new function for the user input.*/
            
            int Size = Integer.parseInt(scn.nextLine());/*parse= parses a string argument as a
            signed decimal integer.*/
            
            if (Size > 15 || Size <= 0){/*if the size is bigger than 15 or smaller/ equal to 0 then the following code will run*/
                System.out.println("Size out of range.");/*This will print*/
                System.exit(0);/*code stops*/
            }
            
            String Name = args[3];/*This extracts the string argument and binds it to the "Name" variable*/
            
            if (Name.length() > 10 || Name.length() <= 0){/*if the length of the above variable is bigger than 10 or 
                smaller/ equal to 0 then...*/
                System.out.println("Name Too big.");/*prints out this statement*/
                System.exit(0);/*code stops*/
            }
            
            /*Sending the job to server*/
            String jobMsg = "JOB/" + Size + "/" + Name;/*the variable "jobMsg" contains
            the "JOB/" string, the size and name of the job message*/
            
            /*Datagram Packets=Used to implement a connectionless packet delivery service*/
            DatagramPacket packet = new DatagramPacket(jobMsg.getBytes(), jobMsg.getBytes().length, addr, port);/*the variable 
            "packet" creates a new DatagramPacket function that extraxts the bytes of the jobMsg variable and the length of the bytes.
            This follows by the address and port*/
            
            DatagramSocket socket = new DatagramSocket(9999, InetAddress.getLocalHost());/*This dynamically gets the IP address*/
            socket.send(packet);/*sends the data*/
            /*job sent*/
            
            /*catches an invalid IP error*/
        } catch (UnknownHostException ex) {
            System.out.println("Invalid IP Supplied.");
            System.exit(0);
         /*-----------------------------------------------*/
            /*catches an error with the socket*/
        } catch (SocketException ex) {
            System.out.println("Exception with Socket.");
            System.exit(0);
         /*------------------------------------------------*/
            /*catches an error while sending a packet*/
        } catch (IOException ex) {
            System.out.println("Exception while Sending packet.");
            System.exit(0);
        }
        /*--------------------------------------------------------*/
    }
    
}
