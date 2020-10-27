package Tests;

import ex0.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Graph_AlgoTest {

    @Test
    public void init() {
    }

    @Test
    public void copy() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        g.connect(node1.getKey(), node2.getKey());
        g.connect(node2.getKey(), node3.getKey());
        g.connect(node1.getKey(), node3.getKey());
        graph_algorithms ga = new Graph_Algo();
        ga.init(g);
        graph g2 = ga.copy();
        g2.addNode(node4);
        assertTrue(g2.nodeSize() == 4);
        System.out.println(g.nodeSize());
        //assertTrue(g.nodeSize() == 3); // need to be 3


    }

    @Test
    public void isConnected() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        g.connect(node1.getKey(), node2.getKey());
        g.connect(node2.getKey(), node3.getKey());
        g.connect(node1.getKey(), node3.getKey());
        Graph_Algo ga1 = new Graph_Algo(g);
        g.connect(node2.getKey(), node4.getKey());
        Graph_Algo ga2 = new Graph_Algo(g);
        assertTrue(ga2.isConnected());
    }

    @Test
    public void shortestPathDist() {
    }

    @Test
    public void shortestPath() {
    }

    @Test
    public void BFS() {
    }
}