package ex0;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class NodeData implements node_data {

    /******fields******/
    private int _key; //key for this node
    private HashMap<Integer,node_data> _mapNode;
    private String _info; //data of this node
    private int _tag; //
    private static int _countNodes = 0; //this countNodes let new key for new node
    /******************/
    public NodeData()
    {
        this._key = _countNodes;
        ++_countNodes;
        this._mapNode = new HashMap<Integer,node_data>();
        _info = null;
        _tag = 0;
    }


    public NodeData(int key)
    {
        this._key = key;
        this._mapNode = new HashMap<Integer,node_data>();
        _info = null;
        _tag = 0;
    }

    @Override
    public int getKey() {
        return this._key; // return this key of this node
    }

    /**
     *
     * @return collection with all the Neighbor nodes of this node_data
     */
    @Override
    public Collection<node_data> getNi() {
        return _mapNode.values();
    }

    /**
     *
     * @param key of the other node_data
     * @return true if other node by the key is neighbor of the this node_data
     */
    @Override
    public boolean hasNi(int key) {
        return _mapNode.containsKey(key);
    }

    /**
     * This method adds the node_data (t) to this node_data.
     * @param t the other node_data that we want to add
     */
    @Override
    public void addNi(node_data t) {
        _mapNode.put(t.getKey(), t);
    }

    /**
     * This method remove neighbor node from this node
     * @param node the other node_data that we want to remove
     */
    @Override
    public void removeNode(node_data node) {
        _mapNode.remove(node.getKey());
    }

    /**
     *
     * @return data of this node_data
     */
    @Override
    public String getInfo() {
        return _info;
    }

    @Override
    public void setInfo(String s) {
        this._info = s;
    }

    @Override
    public int getTag() {
        return this._tag;
    }

    @Override
    public void setTag(int t) {
        this._tag = t;
    }

    @Override
    public String toString()
    {
        return "key = " + _key + " info = " + _info + " tag = " + _tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeData nodeData = (NodeData) o;

        return _key == nodeData.getKey();
//        return _key == nodeData._key &&
//                _tag == nodeData._tag &&
//                Objects.equals(_mapNode, nodeData._mapNode) &&
//                Objects.equals(_info, nodeData._info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_key, _mapNode, _info, _tag);
    }
}
