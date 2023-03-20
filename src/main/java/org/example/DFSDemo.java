package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.Stack;

import lombok.Data;
import lombok.ToString;

public class DFSDemo {
   static GraphNode n1=new GraphNode("A");
   static GraphNode n2=new GraphNode("B");
   static GraphNode n3=new GraphNode("C");
   static GraphNode n4=new GraphNode("D");
   static GraphNode n5=new GraphNode("E");
   static GraphNode n6=new GraphNode("F");

    public static void main(String[] args) {
        populateGraph();

        new DFSSearch().printGraph(n1);

        List.of(n1,n2,n3,n4,n5,n6).forEach(n -> n.setVisited(false));
        boolean hasPath = new DFSSearch().hasPath(n1, "F");
        System.out.println("Has Path from A to F : "+hasPath);

        List.of(n1,n2,n3,n4,n5,n6).forEach(n -> n.setVisited(false));
        hasPath = new DFSSearch().hasPath(n2, "F");
        System.out.println("Has Path from B to F : "+hasPath);
    }

    private static void populateGraph() {

        n1.childNodes=List.of(n2,n3);
        n2.childNodes=List.of(n4);
        n3.childNodes=List.of(n5,n6);
    }
}

class DFSSearch{
    public void printGraph(GraphNode startNode){
       Stack<GraphNode> dfsStack=new org.example.Stack<>();
        dfsStack.push(startNode);
        while (!dfsStack.empty()){
            GraphNode current = dfsStack.pop();
            if(!current.isVisited){
                current.setVisited(true);
                System.out.println(current.data);
                current.childNodes.forEach(dfsStack::push);
            }
        }
    }
    public boolean hasPath(GraphNode source,String destination){
        StackVersion2<GraphNode> dfsStack=new StackVersion2<>();
        dfsStack.push(source);
        while (!dfsStack.isEmpty()){
            GraphNode current = dfsStack.pop();
            if(!current.isVisited){
                current.setVisited(true);
                if(destination.equals(current.data)){
                    return true;
                }
                current.childNodes.forEach(dfsStack::push);
            }
        }
        return false;
    }
}

@Data
class GraphNode {
    @ToString.Exclude
    List<GraphNode> childNodes=new ArrayList<>();
    boolean isVisited;
    String data;

    public GraphNode(String data) {
        this.data = data;
    }
}