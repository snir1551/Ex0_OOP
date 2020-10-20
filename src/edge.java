public class edge implements edge_data {

    /******fields******/
    private int src; // The id of the source node of this edge
    private int dest; // The id of the destination node of this edge
    private String info; // the remark (meta data) associated with this edge
    private int tag; //

    @Override
    public int getSrc() {
        return this.src; // return the id of the source node of this edge
    }

    @Override
    public int getDest() {
        return this.dest; // return the id of the destination node of this edge
    }

    @Override
    public String getInfo() {
        return this.info; // return the remark (meta data) associated with this edge
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
