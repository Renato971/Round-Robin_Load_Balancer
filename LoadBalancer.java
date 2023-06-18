/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.net.InetAddress;

/**
 *
 * @author dushk
 */
public class LoadBalancer {
    
    InetAddress lbIP;
    int port;
    
    public LoadBalancer(int p, InetAddress a){
        this.port = p;/*gets port number for this java class*/
        this.lbIP = a;/*gets ip for this java class*/
    }
}
