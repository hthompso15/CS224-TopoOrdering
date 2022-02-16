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
    ArrayList<Node> topo = new ArrayList<Node>();
    
    // Make O(n+m) --> Currently O(n^2) i think
    // Make second for look be recursive somehow
    
    for(Node n: this.nodes) { 
      if(n.adjlistIn.size() == 0 ) { 
        topo.add(n);
        n.active = false;
        for(Node i : n.adjlistOut) {
          i.adjlistIn.remove(n);
        } 
      }
    }  
    
    //if (all nodes are in topo) {
      // System.out.println(topo);
      //return true;
    //}
    //else:
      //System.out.print("There is no ordering");
      //return false;
    


    System.out.println(topo);
    return false;

  }
}
