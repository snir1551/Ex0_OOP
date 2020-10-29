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

    /**
     * Init this set of algorithms on the parameter - graph.
     * @param g is graph interface
     */
    @Override
    public void init(graph g) {
        this._graph = g;
    }

    /**
     * Compute a deep copy of this graph.
     * @return graph
     */
    @Override
    public graph copy() {
        Graph_DS g = new Graph_DS(_graph);
        return g;
    }

    /**
     * by algorithm BFS we're checking connectivity of the graph if all the nodes are WHITE return false else true
     * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
     * @return true if and only if (iff) there is a valid path from EVREY node to each
     */
    @Override
    public boolean isConnected()
    {
        if(_graph.nodeSize() == 0)
            return true;

        BFS(_graph.getV().iterator().next());

        for(node_data node : _graph.getV())
        {
            if(node.getInfo().equals("WHITE"))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * by algorithm BFS we're getting the shortest path from node to other node by tag
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        if(_graph.getNode(src) == null || _graph.getNode(dest) == null)
        {
            return -1;
        }

        this.BFS(_graph.getNode(src));
        int dist = _graph.getNode(dest).getTag();

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }

    /**
     * by algorithm BFS we're
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
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

    /**
     * BFS algorithms :
     * He goes over all the vertices in the graph and paints them white by info
     * and he puts on them distance Max_Value by tag and add to bfsMap the all this nodes by value null
     * after all that we're setting color gray to start node by info and distance 0 by tag
     * and after that we init queue of node_data
     * and add the start node to the queue
     * while queue is not empty we're doing:
     * 1)remove the first from the queue
     * 2)go through all the vertex neighbors of the vertex we removed if neighbor node painted white
     *   - we're setting his color to gray
     *   - we're setting his distance to his father(node that we removed from queue) distance + 1
     *   - we're setting to the mapBfs his father node
     * 3)we're setting the node that we removed from queue to black
     * 4)return the mapBfs that contains all fathers in the path
     *
     * @param n
     * @return
     */
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
