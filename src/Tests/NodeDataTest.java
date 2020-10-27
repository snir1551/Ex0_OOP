package Tests;

import ex0.NodeData;
import ex0.node_data;

import java.util.Collection;

import static org.junit.Assert.*;

public class NodeDataTest {

    @org.junit.Test
    public void getKey() {
        node_data node1 = new NodeData(3);
        assertTrue(node1.getKey() == 3);
        node_data node2 = new NodeData(-1);
        assertTrue(node2.getKey() == -1);
    }

    @org.junit.Test
    public void getNi() {
        node_data node1 = new NodeData(2);
        node_data node2 = new NodeData(4);
        node_data node3 = new NodeData(5);
        node_data node4 = new NodeData(5);
        boolean isCollection = true;
        node1.addNi(node4);
        node1.addNi(node2);
        node1.addNi(node3);
        Collection<node_data> collectionNode = node1.getNi();
        for(node_data n : collectionNode)
        {
            if(n.getKey() != node2.getKey() && n.getKey() != node3.getKey() && n.getKey() != node4.getKey()) {
                isCollection = false;
                break;
            }

        }

        assertTrue(isCollection);

    }

    @org.junit.Test
    public void hasNi() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        assertFalse(node1.hasNi(node2.getKey()));
        assertFalse(node1.hasNi(node3.getKey()));
        node1.addNi(node2);
        assertTrue(node1.hasNi(node2.getKey()));
        assertFalse(node1.hasNi(node3.getKey()));
        node1.addNi(node3);
        assertTrue(node1.hasNi(node2.getKey()));
        assertTrue(node1.hasNi(node3.getKey()));

    }

    @org.junit.Test
    public void addNi() {
        node_data node1 = new NodeData(2);
        node_data node2 = new NodeData(4);
        node_data node3 = new NodeData(5);
        node_data node4 = new NodeData(5);
        node1.addNi(node4);
        node1.addNi(node2);
        node1.addNi(node3);
        boolean isfind = false;
        for(node_data n : node1.getNi())
        {
            if(n.getKey() == node2.getKey())
                isfind = true;
        }
        assertTrue(isfind);

    }

    @org.junit.Test
    public void removeNode() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node1.addNi(node2);
        node1.addNi(node3);
        assertTrue(node1.hasNi(node2.getKey()));
        assertTrue(node1.hasNi(node3.getKey()));
        node1.removeNode(node2);
        assertFalse(node1.hasNi(node2.getKey()));
        assertTrue(node1.hasNi(node3.getKey()));
    }

    @org.junit.Test
    public void getInfo() {
        node_data node1 = new NodeData();
        assertNull(node1.getInfo());
        node_data node2 = new NodeData(2);
        assertNull(node2.getInfo());
    }

    @org.junit.Test
    public void setInfo() {
        node_data node1 = new NodeData();
        assertNull(node1.getInfo());
        node1.setInfo("Gray");
        assertTrue(node1.getInfo().equals("Gray"));
        assertFalse(node1.getInfo().equals("Gra"));
        assertNotNull(node1.getInfo());
    }

    @org.junit.Test
    public void getTag() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData(3);
        assertTrue(node1.getTag() == 0);
        assertTrue(node2.getTag() == 0);
    }

    @org.junit.Test
    public void setTag() {
        node_data node1 = new NodeData();
        node_data node2 = new NodeData(3);
        assertTrue(node1.getTag() == 0);
        assertTrue(node2.getTag() == 0);
        node1.setTag(Integer.MAX_VALUE);
        node2.setTag(3);
        assertTrue(node1.getTag() == Integer.MAX_VALUE);
        assertTrue(node2.getTag() == 3);
    }

}