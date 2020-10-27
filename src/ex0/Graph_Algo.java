package ex0;

import java.lang.reflect.Array;
import java.util.*;

public class Graph_Algo implements graph_algorithms {

    private graph _graph;

    public Graph_Algo()
    {
        _graph = null;
    }
    public Graph_Algo(graph g)
    {
        init(g);
    }

    @Override
    public void init(graph g) {
        this._graph = g;
    }

    @Override
    public graph copy() {
        Graph_DS g = new Graph_DS(_graph);
        return g;
    }

    @Override
    public boolean isConnected()
    {
        if(_graph.nodeSize() == 0)
            return true;
        this.BFS(_graph.getV().iterator().next());
        for(node_data node : _graph.getV())
        {
            if(!node.getInfo().equals("BLACK"))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        if(_graph.getNode(src) == null || _graph.getNode(dest) == null)
        {
            return Integer.MAX_VALUE;
        }
        this.BFS(_graph.getNode(src));
        return _graph.getNode(dest).getTag();
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        LinkedList<node_data> list = new LinkedList<>();
        if(_graph.getNode(src) == null || _graph.getNode(dest) == null)
        {
            return null;
        }
        if(src == dest)
        {
            list.add(_graph.getNode(src));
            return list;
        }
        HashMap<Integer,node_data> pv = BFS(this._graph.getNode(src));
        if(_graph.getNode(dest).getTag() == Integer.MAX_VALUE)
        {
            return null;
        }

        list.addFirst(_graph.getNode(dest));
        node_data t = pv.get(dest);

        while(t != null)
        {
            list.addFirst(_graph.getNode(t.getKey()));
            t = pv.get(t.getKey());
        }

        return list;
    }

    public HashMap<Integer,node_data> BFS(node_data n) // O(|V|+|E|)
    {
        HashMap<Integer,node_data> bfsMap = new HashMap<>();
        for(node_data node : _graph.getV())
        {
            node.setInfo("WHITE"); // all nodes WHITE
            node.setTag(Integer.MAX_VALUE); // all nodes MAX_VALUE
            bfsMap.put(node.getKey(),null);
        }
        n.setInfo("Gray");
        n.setTag(0);
        Queue<node_data> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty())
        {
            node_data newNode = q.remove();
            for(node_data node : newNode.getNi())
            {
                if(node.getInfo().equals("WHITE"))
                {
                    node.setInfo("GRAY");
                    node.setTag(newNode.getTag() + 1);
                    q.add(node);
                    bfsMap.put(node.getKey(),newNode);
                }
            }
            newNode.setInfo("BLACK");
        }
        return bfsMap;
    }


}
