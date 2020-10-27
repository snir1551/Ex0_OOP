package Tests;

import ex0.Graph_DS;
import ex0.NodeData;
import ex0.graph;
import ex0.node_data;
import org.junit.Test;

public class Graph_Ex0_ComplexTest {

    @Test
    public void Test1()
    {
        int vertex = 1000000;
        int edges = vertex*10;
        graph g = new Graph_DS();
        for(int i = 0; i< 1000000; i++)
        {
            node_data node = new NodeData();
            g.addNode(node);
        }
        for(int i = 0; i<vertex/2; i++)
        {
            g.connect(i,i+1);
        }
    }
}
