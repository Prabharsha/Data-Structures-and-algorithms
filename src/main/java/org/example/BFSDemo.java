package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDemo {
    static GraphNode n1=new GraphNode("A");
    static GraphNode n2=new GraphNode("B");
    static GraphNode n3=new GraphNode("C");
    static GraphNode n4=new GraphNode("D");
    static GraphNode n5=new GraphNode("E");
    static GraphNode n6=new GraphNode("F");

    public static void main(String[] args) {
        populateGraph();

        new BFSSearch().printGraph(n1);

        List.of(n1,n2,n3,n4,n5,n6).forEach(n -> n.setVisited(false));
        boolean hasPath = new BFSSearch().hasPath(n1, "F");
        System.out.println("Has Path from A to F : "+hasPath);

        List.of(n1,n2,n3,n4,n5,n6).forEach(n -> n.setVisited(false));
        hasPath = new BFSSearch().hasPath(n2, "F");
        System.out.println("Has Path from B to F : "+hasPath);
    }

    private static void populateGraph() {

        n1.childNodes=List.of(n2,n3);
        n2.childNodes=List.of(n4);
        n3.childNodes=List.of(n5,n6);
    }
}

class BFSSearch{

    public void printGraph (GraphNode source){
        Queue<GraphNode> queue =new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()){
            GraphNode current = queue.poll();
            if(!current.isVisited){
                current.setVisited(true);
                System.out.println(current.data);
                queue.addAll(current.childNodes);
            }
        }
    }

    public boolean hasPath(GraphNode source, String destination) {
        Queue<GraphNode> queue =new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()){
            GraphNode current = queue.poll();
            if(!current.isVisited){
                current.setVisited(true);
                if(destination.equals(current.data)){
                    return true;
                }
                queue.addAll(current.childNodes);
            }
        }
        return false;
    }
}