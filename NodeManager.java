package loadbalancermaster;
import java.net.InetAddress;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shala
 */
public class NodeManager {
    //data
    private LinkedList<NodeMaster> availableNodes; /* Takes a list of available nodes*/
    private int currentNode;
    
    public NodeManager() {
        availableNodes = new LinkedList<NodeMaster>(); /* make a variable that contains a list that the nodes will enter*/
        currentNode = 0;
    }
    
    public void addNode(String name, InetAddress addr, int port, int maxLoad){
        this.availableNodes.add(new NodeMaster(addr, port, name, maxLoad));
    }
    
    public NodeMaster findNode(String name) {
        for (NodeMaster nNode: this.availableNodes) {
            if (nNode.getNodeName().equals(name)) {
                return nNode;
            }
        }
        return null;
    }
    
    public NodeMaster getNextNode() {
        if ((currentNode + 1) > availableNodes.size()) {
            currentNode = 1;
        } else {
            currentNode ++;
        }
        return availableNodes.get(currentNode - 1);
    }
}
