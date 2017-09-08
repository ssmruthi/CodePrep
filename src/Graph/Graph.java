package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

class Node{
  LinkedList<Node> child= new LinkedList<Node>();
  int id;
  
  Node(int i){
	  this.id=i;
  }
}

public class Graph{

  Map<Integer,Node> map=new HashMap<Integer,Node>();

  public void getNode(int i){
    map.get(i);
  }


  public boolean dfs (int s, int d){

      Node source= map.get(s);
      Node destination= map.get(d);
      return dfs(source,destination, new HashSet<Node>());
  
  }

  public boolean bfs(int s, int d){
      Node source= map.get(s);
      Node destination=map.get(d);

      return bfs(source,destination);
  }

  private boolean dfs(Node source, Node destination, HashSet<Node> visited){

      if(source==destination)
        return true;

      if(visited.contains(source))
        return false;

        visited.add(source);

      for(Node child: source.child){
        boolean hasPath=dfs(child,destination,visited);
        if(hasPath)
          return true;
      }

      return false;
  }


  private boolean bfs(Node source, Node destination){
      LinkedList<Node> children = new LinkedList<Node>();
      HashSet<Node> visited= new HashSet<Node>();

      children.add(source);
      while(!children.isEmpty()) {

        Node node=children.poll();

        if(!visited.contains(node)){
        	if(node==destination)
            return true;

            for(Node child:node.child){
              children.add(child);
            }
            
            visited.add(node);
        }
   
      }

      return false;
      
  }
  
  
  public static void main(String[] args){

	  Graph g= new Graph();
	  g.map=new HashMap<Integer,Node>();
	  	for(int i=1;i<=6;i++){
	  		g.map.put(i,new Node(i));
	  	}
	  	
	  	Node n1=g.map.get(1);
	  	Node n2=g.map.get(2);
	  	Node n3=g.map.get(3);
	  	Node n4=g.map.get(4);
	  	Node n5=g.map.get(5);
	  	Node n6=g.map.get(6);

	  	
	  	n1.child.add(n2);
	  	n1.child.add(n3);
	  	n1.child.add(n4);
	  	n3.child.add(n4);
	  	n3.child.add(n5);
	  	n4.child.add(n5);
	  	n4.child.add(n6);

	  	System.out.println(g.bfs(1, 6));
	  	System.out.println(g.dfs(1, 6));
  }
  


  
        
  
  }

