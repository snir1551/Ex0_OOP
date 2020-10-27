package Tests;

import ex0.Graph_DS;
import ex0.NodeData;
import ex0.graph;
import ex0.node_data;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class Graph_DSTest {

    @Test
    public void getNode() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        g.addNode(node1);
        assertTrue(g.getNode(node1.getKey()).equals(node1));
    }

    @Test
    public void hasEdge() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        assertFalse(g.hasEdge(node1.getKey(),node2.getKey()));
        g.connect(node1.getKey(),node2.getKey());
        assertTrue(g.hasEdge(node1.getKey(),node2.getKey()));

    }

    @Test
    public void addNode() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        assertTrue(g.nodeSize() == 0);
        g.addNode(node1);
        assertTrue(g.nodeSize() == 1);
        //g.addNode(null);
        //assertTrue(g.nodeSize() == 2);
    }

    @Test
    public void connect() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        g.connect(node1.getKey(),node2.getKey());
        assertTrue(g.hasEdge(node1.getKey(),node2.getKey()));
    }

    @Test
    public void getV() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);

        for(node_data n : g.getV())
        {

        }

    }

    @Test
    public void testGetV() {

    }

    @Test
    public void removeNode() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        g.removeNode(node1.getKey());
        assertTrue(g.nodeSize() == 0);
        g.addNode(node1);
        assertTrue(g.nodeSize() == 1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        assertTrue(g.nodeSize() == 4);
        g.connect(node1.getKey(),node2.getKey());
        g.connect(node1.getKey(),node3.getKey());
        g.connect(node1.getKey(),node4.getKey());
        assertTrue(g.edgeSize() == 3);
        g.removeNode(node1.getKey());
        assertNull(g.getNode(node1.getKey()));
        assertTrue(g.nodeSize() == 3);
        System.out.println(g.edgeSize());
        //assertTrue(g.edgeSize() == 0); // need to be 0

    }

    @Test
    public void removeEdge() {

    }

    @Test
    public void nodeSize() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        node_data node5 = new NodeData();
        graph g = new Graph_DS();
        assertTrue(g.nodeSize() == 0);
        g.addNode(node1);
        assertTrue(g.nodeSize() == 1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        assertTrue(g.nodeSize() == 4);
    }

    @Test
    public void edgeSize() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        node_data node5 = new NodeData();
        graph g = new Graph_DS();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        assertTrue(g.edgeSize() == 0);
        g.connect(node1.getKey(),node3.getKey());
        assertTrue(g.edgeSize() == 1);
        g.connect(node1.getKey(),node2.getKey());
        assertTrue(g.edgeSize() == 2);
        g.connect(node1.getKey(),node3.getKey());
        assertTrue(g.edgeSize() == 2);
    }

    @Test
    public void getMC() {
    }
}