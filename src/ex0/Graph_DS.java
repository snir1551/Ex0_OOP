package ex0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Graph_DS implements graph {

    /******fields******/

    private HashMap<Integer, node_data> mapNode;
    private int countEdges = 0;
    private int MC = 0;
    /******************/

    //Constructor
    public Graph_DS()
    {
        mapNode = new HashMap<>();
    }

    @Override
    public node_data getNode(int key) {
        return mapNode.get(key); //return the node_data by key
    }

    //O(1)
    @Override
    public boolean hasEdge(int node1, int node2) {
        if(mapNode.containsKey(node1))
            return mapNode.get(node1).hasNi(node2);
        else
            return false;
    }
    //O(1)
    @Override
    public void addNode(node_data n) {
        mapNode.put(n.getKey(),n);
        ++MC;
    }

    @Override
    public void connect(int node1, int node2) {
        if(mapNode.containsKey(node1) && mapNode.containsKey(node2) && !mapNode.get(node1).hasNi(node2))
        {
            mapNode.get(node1).addNi(mapNode.get(node2));
            mapNode.get(node2).addNi(mapNode.get(node1));
            ++countEdges;
            ++MC;
        }
    }

    @Override
    public Collection<node_data> getV() { //ask
        return mapNode.values();
    }

    @Override
    public Collection<node_data> getV(int node_id) {
        if(!mapNode.containsKey(node_id))
            throw new IllegalArgumentException("node doesnt exist");
        else
            return mapNode.get(node_id).getNi();
    }

    @Override
    public node_data removeNode(int key) {
        if(mapNode.containsKey(key)) {
            mapNode.get(key).getNi().clear();
            for(node_data nd : mapNode.values()) {
                nd.removeNode(mapNode.get(key));
            }
            ++MC;
        }
        return mapNode.remove(key);

    }
    //O(1)
    @Override
    public void removeEdge(int node1, int node2) {
        if(mapNode.containsKey(node1) && mapNode.containsKey(node2) && mapNode.get(node1).hasNi(node2))
        {
            mapNode.get(node1).removeNode(mapNode.get(node2));
            mapNode.get(node2).removeNode(mapNode.get(node1));
            --countEdges;
            ++MC;
        }
    }

    @Override
    public int nodeSize() {
        return mapNode.size();
    }

    @Override
    public int edgeSize() {
        return countEdges;
    }

    @Override
    public int getMC() {
        return MC;
    }
}
