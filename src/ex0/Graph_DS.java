package ex0;

import java.util.Collection;
import java.util.HashMap;

public class Graph_DS implements graph {

    /******fields******/

    private HashMap<Integer, node_data> nodes;

    /******************/

    //Constructor
    public Graph_DS()
    {
        nodes = new HashMap<>();
    }

    @Override
    public node_data getNode(int key) {
        return nodes.get(key); //return the node_data by key
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
        return false;
    }

    @Override
    public void addNode(node_data n) {

    }

    @Override
    public void connect(int node1, int node2) {

    }

    @Override
    public Collection<node_data> getV() {
        return null;
    }

    @Override
    public Collection<node_data> getV(int node_id) {
        return null;
    }

    @Override
    public node_data removeNode(int key) {
        return null;
    }

    @Override
    public void removeEdge(int node1, int node2) {

    }

    @Override
    public int nodeSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
