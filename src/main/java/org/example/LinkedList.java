package org.example;

import java.security.PublicKey;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteByData(int data){
        if(head ==null){
            return;
        }
        if(head.data==data){
            head=head.next;
            return;
        }

        Node currentNode=head;
        while (currentNode.next!=null){
            if(currentNode.next.data==data){
                currentNode.next=currentNode.next.next;
                return;
            }
            currentNode=currentNode.next;
        }
    }
}
