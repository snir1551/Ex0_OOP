package ex0;


import java.util.Collection;
import java.util.HashMap;

public class Graph_DS implements graph {

    /******fields******/

    private HashMap<Integer, node_data> mapNode;
    private int countEdges; //count numbers of edges in the graph
    private int MC; // count for testing changes in the graph.
    /******************/

    //Constructor
    public Graph_DS()
    {
        mapNode = new HashMap<>();
        countEdges = 0;
        MC = 0;
    }

    /**
     * Copy Constructor
     * one foreach we're add new node_data
     * second foreach we're connecting the nodes
     * @param g
     */
    public Graph_DS(graph g)
    {
        this();

        for(node_data nd : g.getV())
        {
            this.addNode(new NodeData(nd.getKey()));
        }
        for(node_data nd : g.getV())
        {
            for(node_data ndd : nd.getNi())
            {
                this.connect(nd.getKey(),ndd.getKey());
            }
        }
    }

    /**
     *
     * @param key - the node_id
     * @return the node_data by key
     */
    @Override
    public node_data getNode(int key) {
        return mapNode.get(key); //return the node_data by key
    }

    /**
     * Note: this method run in O(1) time.
     * @param node1 the node_id
     * @param node2 the node_id
     * @return true if and only if there is an edge between node1 and node2
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
        if(mapNode.containsKey(node1))
            return mapNode.get(node1).hasNi(node2);
        else
            return false;
    }

    /**
     * This method add node to the graph
     * @param n the node_data
     */
    @Override
    public void addNode(node_data n) {
        mapNode.put(n.getKey(),n);
        ++MC; //add +1 to changes in the graph
    }

    /**
     * This method connect an edge between node1 and node2.
     * @param node1 the node_id
     * @param node2 the node_id
     */
    @Override
    public void connect(int node1, int node2) {
        if(mapNode.containsKey(node1) && mapNode.containsKey(node2) && !mapNode.get(node1).hasNi(node2))
        {
            mapNode.get(node1).addNi(mapNode.get(node2));
            mapNode.get(node2).addNi(mapNode.get(node1));
            ++countEdges; //add +1 to counter edges
            ++MC; //add +1 to changes in the graph
        }
    }

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method run in O(1) time.
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV() {
        return mapNode.values();
    }

    /**
     * This method return a collection of  the all the nodes connected to node_id
     * @param node_id the key of the node_data
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        if(!mapNode.containsKey(node_id))
            throw new IllegalArgumentException("node doesnt exist");
        else
            return mapNode.get(node_id).getNi();
    }

    /**
     * This method remove node_data from the graph
     * @param key the node_id
     * @return node_data
     */
    @Override
    public node_data removeNode(int key) {
        if(mapNode.containsKey(key)) {
            mapNode.get(key).getNi().clear();
            for(node_data nd : mapNode.values()) {
                nd.removeNode(mapNode.get(key));
            }
            ++MC; //add +1 to changes in the graph
        }
        return mapNode.remove(key);

    }

    /**
     * This method remove edge from the graph
     * @param node1 key of the node1
     * @param node2 key of the node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        if(mapNode.containsKey(node1) && mapNode.containsKey(node2) && mapNode.get(node1).hasNi(node2))
        {
            mapNode.get(node1).removeNode(mapNode.get(node2));
            mapNode.get(node2).removeNode(mapNode.get(node1));
            --countEdges; //add -1 to counter edges
            ++MC; // add +1 to changes in the graph
        }
    }

    /**
     *
     * @return number of the nodes in the graph
     */
    @Override
    public int nodeSize() {
        return mapNode.size();
    }

    /**
     *
     * @return the number of the edges in the graph
     */
    @Override
    public int edgeSize() {
        return countEdges;
    }

    /**
     *
     * @return number of the changes in the graph
     */
    @Override
    public int getMC() {
        return MC;
    }

    @Override
    public String toString()
    {
        String ans = "";
        for(node_data node : mapNode.values())
        {
            ans += "[" + node.getKey() + "] -> [";
            int num = node.getNi().size() -1;
            for(node_data n : node.getNi()) {
                ans += n.getKey();
                if(num > 0) {
                    ans += ", ";
                    --num;
                }
            }
            ans += "]\n";
        }
        return ans;
    }
}
