import java.util.ArrayList;


public class Graph {
  ArrayList<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<Node>();
  }

  public void addNode(Node n) {
    this.nodes.add(n);
  }

  public void removeNode(Node n) {
    this.nodes.remove(n);
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
    
    // Begin the ordering for reference
    System.out.println("Begin Topological Ordering");

    // Create array to store the topo ordering
    ArrayList<Node> topo = new ArrayList<Node>();

    // Go through each note and assign the num
    // in from active to the num in
    for(Node n: this.nodes) {
      n.numInFromActive = n.adjlistIn.size();
    }

    // For each node in the graph
    for(Node n: this.nodes) { 
      
      // Print out the number of current incoming nodes
      for (Node j : this.nodes) {
        System.out.println("node " + j + " : #incoming edges from active nodes = " + j.numInFromActive);
      }
      System.out.println();
      
      /** If there are no incoming nodes for that node
          Add it to the topo ordering - set it to not active
          and subtract it from current incoming nodes
          of the nodes it connects too
      */ 
      if(n.numInFromActive == 0 ) { 
        topo.add(n);
        n.active = false;
        for(Node i : n.adjlistOut) {
          i.numInFromActive--;
        }
      }
    }

    // Printing and returning
    boolean order = false;
    int topo_size = topo.size();
    int node_size = this.nodes.size();

    if(topo_size == node_size) {
      System.out.println(topo);
      System.out.println();
      order = true;
    }
    if(topo_size != node_size){
      System.out.println("There is no topological ordering for this graph\n");
      order = false;
    }

    return order;
  } 
}

