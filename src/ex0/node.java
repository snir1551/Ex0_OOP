package ex0;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class node implements node_data {

    /******fields******/
    private int key; //key for this node
    private HashMap<Integer,node_data> mapNode;
    private String info;
    private int tag;
    /******************/

    public node(int key)
    {
        this.key = key;
        this.mapNode = new HashMap<>();
    }

    @Override
    public int getKey() {
        return this.key; // return this key of this node
    }

    @Override
    public Collection<node_data> getNi() {
        return mapNode.values();
    }

    @Override
    public boolean hasNi(int key) {
        return mapNode.containsKey(key);
    }

    @Override
    public void addNi(node_data t) {
        mapNode.put(this.key,t);
    }

    @Override
    public void removeNode(node_data node) {
        mapNode.remove(node.getKey());
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}
