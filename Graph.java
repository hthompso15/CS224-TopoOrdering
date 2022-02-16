import java.util.ArrayList;

public class Graph {
  ArrayList<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<Node>();
  }

  public void addNode(Node n) {
    this.nodes.add(n);
  }

  public void addEdge(Node n1, Node n2) {
    // outgoing edge
    int idx1 = this.nodes.indexOf(n1);
    if (idx1 < 0) {
      System.out.println("node " + n1.name + " not found in graph");
      return;
    }

    // incoming edge
    int idx2 = this.nodes.indexOf(n2);
    if (idx2 < 0) {
      System.out.println("node " + n2.name + " not found in graph");
      return;
    }

    n1.addEdge(n2);
  }

  public void print() {
    for (Node n: this.nodes) {
      System.out.print("Node " + n.name + ":");
      for (Node n2: n.adjlistOut)
        System.out.print(" " + n2.name);
      System.out.print(" |");
      for (Node n2: n.adjlistIn)
        System.out.print(" " + n2.name);
      System.out.println();
    }
  }

  public boolean topoOrder() {

    return false;
    // implement this
    /**
     * go to V1 node that has no incoming edges,
     * delete it and add it top a set 
     * go to node V1+N that has edge connected to V1 
     * delete it and at it to a set, 
     * recursively run this until there are no more nodes 
     * the original set
     *
     * declare a node to be “active” if it has not yet been deleted by the algorithm
     * explicitly maintain two other pieces of information
     *  (a) for each node W, the number of incoming edges that W has from active nodes
     *  (b) the set S of all active nodes in G that have no incoming edges from other active nodes
     *  at the start, all nodes are active, so we can initialize (a) and (b) with a single pass through the nodes
     *  and edges
     * 
     * then, at each iteration:
     * – select a node V from the set S and delete it
     * – after deleting V, go through all of the nodes W to which V had an edge, and subtract one from the number of active
     * incoming edges that we are maintaining for W
     * – if this causes the number of active incoming edges to W to drop to zero, then we add W to the set S
     * 
     *
     * 
     */
    




  }
}
