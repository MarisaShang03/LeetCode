package com.company;

public class Edu_linkedlist {
    public class Node {
        public int data;
        public Node nextNode;

    }
    public Node headNode; //head node of the linked list
    public int size;

    public void insertAtEnd(int data) {
        //新node
        Node newNode=new Node();
        newNode.data=data;
        newNode.nextNode=null;

        if(headNode==null){
            headNode=newNode;
            size++;
        }

        Node temp=headNode;
        while (temp!=null){
            temp=temp.nextNode;
        }
        temp.nextNode=newNode;
        size++;
    }
}
