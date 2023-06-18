package loadbalancer1;
import java.net.InetAddress;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dushk
 */
public class NodeManager1 {
    //data
    private LinkedList<Node1> availableNodes; /* Takes a list of available nodes*/
    private int currentNode;
    
    public NodeManager1() {
        availableNodes = new LinkedList<Node1>(); /* make a variable that contains a list that the nodes will enter*/
        currentNode = 0; /*sets value to 0*/
    }
    
    public void addNode(String name, InetAddress addr, int port, int maxLoad){
        this.availableNodes.add(new Node1(addr, port, name, maxLoad));/*adds node to available node list*/
    }
    
    public Node1 findNode(String name) {
        for (Node1 n: this.availableNodes) {/*for every node in available nodes...*/
            if (n.getNodeName().equals(name)) {/*if the node name is equal to the "name"*/
                return n;/*it will return the node*/
            }
        }
        return null;
        
    }
    
    public Node1 getNextNode() {
        System.out.println((currentNode + 1) + " " + availableNodes.size());/*prints the current node 
        (adding one ever time a job is sent), and the size of the available node*/
        if ((currentNode + 1) >= availableNodes.size()) {/*if the current node (and the others added later)
            is bigger than or equal to the "availableNodes" size then....*/
            currentNode = 1;/*the current node is 1*/
        } else {
            currentNode ++;/*otherwise it gets added*/
        }
        return availableNodes.get(currentNode - 1);/*returs the available node and takes 1 away*/
    }
}
