package Tests;

import ex0.Graph_DS;
import ex0.NodeData;
import ex0.graph;
import ex0.node_data;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class Graph_Ex0_ComplexTest {

    @Test
    public void Test1()
    {
        long start = new Date().getTime();
        int vertex = 1000000;
        int edges = vertex*10;
        graph g = new Graph_DS();
        for(int i = 0; i< 1000000; i++)
        {
            node_data node = new NodeData();
            g.addNode(node);
        }
        int i = 0;
        while(edges > g.edgeSize())
        {
            if(i > vertex)
                i=0;
            for(node_data n : g.getV())
            {
              g.connect(n.getKey(),i);
            }
            i++;
        }
        long end = new Date().getTime();
        double dt = (end-start)/1000.0;
        //System.out.println(dt); //3.3sec
        assertTrue(dt < 10.0);
    }
}
