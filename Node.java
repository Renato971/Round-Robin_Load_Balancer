/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author dushk
 */
public class Node {
    
    int load;
    int maxLoad;
    private String name;
    
    public Node(int l, int mL, String n) {
        
        // Constructor.
        this.load = l;
        this.maxLoad = mL;
        this.name = n;
    }
    /*gets the load of the node*/
    public int getLoad() {
        return load;
    }/*---------------*/
    
    /*gets max load on node*/
    public int getMaxLoad() {
        return maxLoad;
    }/*----------------*/
    /*gets string name*/
    public String getName() {
        return name;
    }/*-------------------------*/
    
    
}
