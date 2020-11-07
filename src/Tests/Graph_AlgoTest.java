package Tests;

import ex0.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        node_data node5 = new NodeData();
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
        for(node_data n : g.getV())
        {

            assertTrue(g.getNode(n.getKey()).getKey() == g2.getNode(n.getKey()).getKey());
        }
        g2.addNode(node5);
        assertTrue(g2.nodeSize() == 5);
        assertTrue(g.nodeSize() == 4);

        g.removeEdge(node1.getKey(),node2.getKey());
        g.connect(node1.getKey(),node2.getKey());
        graph_algorithms ga2 = new Graph_Algo();
        ga2.init(g);
        graph g3 = ga2.copy();

        assertTrue(g3.getMC() == 9);
        assertTrue(g.getMC() == 9);
        g3.removeEdge(node1.getKey(), node2.getKey());
        assertTrue(g3.getMC() == 10);
        assertTrue(g.getMC() == 9);
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
        assertFalse(ga1.isConnected());
        g.connect(node2.getKey(), node4.getKey());
        Graph_Algo ga2 = new Graph_Algo(g);
        assertTrue(ga2.isConnected());
        g.removeEdge(node1.getKey(),node2.getKey());
        assertTrue(ga2.isConnected());
        g.removeEdge(node1.getKey(),node3.getKey());
        assertFalse(ga2.isConnected());
    }

    @Test
    public void shortestPathDist() {
        graph g = new Graph_DS();
        node_data node1 = new NodeData();
        node_data node2 = new NodeData();
        node_data node3 = new NodeData();
        node_data node4 = new NodeData();
        node_data node5 = new NodeData();
        node_data node6 = new NodeData();
        node_data node7 = new NodeData();
        node_data node8 = new NodeData();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        g.addNode(node5);
        g.addNode(node6);
        g.addNode(node7);
        g.addNode(node8);
        g.connect(node1.getKey(),node2.getKey());
        g.connect(node1.getKey(),node3.getKey());
        g.connect(node1.getKey(),node3.getKey());
        g.connect(node2.getKey(),node4.getKey());
        g.connect(node4.getKey(),node5.getKey());
        g.connect(node4.getKey(),node6.getKey());
        g.connect(node5.getKey(),node7.getKey());
        g.connect(node5.getKey(),node6.getKey());
        g.connect(node7.getKey(),node6.getKey());
        g.connect(node7.getKey(),node8.getKey());
        g.connect(node6.getKey(),node8.getKey());

        graph_algorithms ga = new Graph_Algo(g);
        int shotestpath1 = ga.shortestPathDist(node2.getKey(),node8.getKey());
        assertTrue(shotestpath1 == 3);
        int shotestpath2 = ga.shortestPathDist(node2.getKey(),node4.getKey());
        assertTrue(shotestpath2 == 1);
        int shotestpath3 = ga.shortestPathDist(node2.getKey(),node5.getKey());
        assertTrue(shotestpath3 == 2);
        int shotestpath4 = ga.shortestPathDist(node2.getKey(),node7.getKey());
        assertTrue(shotestpath4 == 3);
        int shotestpath5 = ga.shortestPathDist(node2.getKey(),node1.getKey());
        assertTrue(shotestpath5 == 1);
        int shotestpath6 = ga.shortestPathDist(node2.getKey(),node3.getKey());
        assertTrue(shotestpath6 == 2);
        int shotestpath7 = ga.shortestPathDist(node2.getKey(),node2.getKey());
        assertTrue(shotestpath7 == 0);
    }

    @Test
    public void shortestPath() {

        graph g = new Graph_DS();
        node_data node0 = new NodeData();//0
        node_data node1 = new NodeData();//1
        node_data node2 = new NodeData();//2
        node_data node3 = new NodeData();//3
        node_data node4 = new NodeData();//4
        node_data node5 = new NodeData();//5
        node_data node6 = new NodeData();//6
        node_data node7 = new NodeData();//7
        g.addNode(node0);
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        g.addNode(node5);
        g.addNode(node6);
        g.addNode(node7);
        g.connect(node0.getKey(),node1.getKey());//1->2
        g.connect(node0.getKey(),node2.getKey());//1->3
        g.connect(node1.getKey(),node3.getKey());//2->4
        g.connect(node3.getKey(),node4.getKey());//4->5
        g.connect(node3.getKey(),node5.getKey());//4->6
        g.connect(node4.getKey(),node6.getKey());//5->7
        g.connect(node4.getKey(),node5.getKey());//5->6
        g.connect(node6.getKey(),node5.getKey());//7->6
        g.connect(node6.getKey(),node7.getKey());//7->8
        g.connect(node5.getKey(),node7.getKey());

        graph_algorithms ga = new Graph_Algo(g);

        List<node_data> list1 = ga.shortestPath(node1.getKey(),node7.getKey());
        List<node_data> list2 = ga.shortestPath(node1.getKey(),node2.getKey());
        List<node_data> list3 = ga.shortestPath(node1.getKey(),node6.getKey());
        int[] ansList1 = {1,3,5,7};
        int[] ansList2 = {1,0,2};
        int i = 0;
        for(node_data node : list1)
        {
            assertTrue(node.getKey() == ansList1[i]);
            ++i;
        }
        i = 0;
        for(node_data node : list2)
        {
            assertTrue(node.getKey() == ansList2[i]);
            ++i;
        }

    }

    @Test
    public void BFS() {
        graph g = new Graph_DS();
        node_data node0 = new NodeData();//0
        node_data node1 = new NodeData();//1
        node_data node2 = new NodeData();//2
        node_data node3 = new NodeData();//3
        node_data node4 = new NodeData();//4
        node_data node5 = new NodeData();//5
        node_data node6 = new NodeData();//6
        node_data node7 = new NodeData();//7
        g.addNode(node0);
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        g.addNode(node5);
        g.addNode(node6);
        g.addNode(node7);
        g.connect(node0.getKey(),node1.getKey());//1->2
        g.connect(node0.getKey(),node2.getKey());//1->3
        g.connect(node1.getKey(),node3.getKey());//2->4
        g.connect(node3.getKey(),node4.getKey());//4->5
        g.connect(node3.getKey(),node5.getKey());//4->6
        g.connect(node4.getKey(),node6.getKey());//5->7
        g.connect(node4.getKey(),node5.getKey());//5->6
        g.connect(node6.getKey(),node5.getKey());//7->6
        g.connect(node6.getKey(),node7.getKey());//7->8
        g.connect(node5.getKey(),node7.getKey());
        Graph_Algo ga = new Graph_Algo(g);
        ga.BFS(node1);
        for(node_data n : g.getV())
        {
            assertTrue(n.getInfo().equals("BLACK"));
        }
        g.removeNode(node0.getKey());
        ga.BFS(node1);
        assertTrue(node2.getInfo().equals("WHITE"));
        assertTrue(node1.getInfo().equals("BLACK"));
    }




}