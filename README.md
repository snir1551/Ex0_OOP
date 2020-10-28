# Ex0_OOP


This project is about an unweighted and undirected graph that is a set of vertices and edges which connect the vertices, 
<br>
edge is actually neighbor vertex of this and this is actually neighbor of the vertex.

in this project we have three classes: NodeData, GraphDS, GraphAlgo.
<br>
for each of the classes we have interface:
- for NodeData class we have node_data interface
- for GraphDS class we have graph interface
- for Graph_Algo class we have graph_algorithms interface
<br>
class NodeData: He builds a vertex that for each vertex he builds he gives a unique key and preserves all its neighbors' vertices
<br>
class GraphDS: builds the graph from vertices, and by neighbors creates edges
<br>
class Graph_Algo: this class does all the complex calculations in the graph
<br>
Example of an unweighted and undirected graph:

<img src="https://github.com/snir1551/Ex0_OOP/blob/master/src/Pictures/graph.png"  width="250">



Algorithm BFS explanation:

<img src="https://github.com/snir1551/Ex0_OOP/blob/master/src/Pictures/algorithmBFS.png"  width="500">

White color - not visited nodes
Gray color - about to be visited (keeping them in FIFO queue)
Black color - visited nodes

for more information: https://github.com/snir1551/Ex0_OOP/wiki/Graph_Algo
