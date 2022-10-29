package com.hasanali.datastructures;

public class LinkedList {

    public LinkedList() {}

    public static Node newNode(int k) {
        return new Node(k);
    }

    public static void displayList(Node head) {
        Node ptr = head;
        while(ptr != null) {
            System.out.println(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public static Node appenNodeHead(Node head, int k) {
        Node current = head;
        Node node =  new Node(k);
        if(current == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        return head;
    }

    public static Node appenNodeTail(Node head, int k) {
        Node current = head;
        Node node = new Node(k);
        if(current == null) {
            head = node;
        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        return head;
    }

    public static Node insertAfter(Node head, int m, int k) {
        Node current = head;
        Node node = new Node(k);
        if(current == null) {
            head = node;
        } else {
            while(current.data != m) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        return head;
    }

    public static int findNthNode(Node head, int n) {
        Node current = head;
        int counter = 1;
        if(current == null) {
            System.out.println("liste bos");
            System.exit(1);
        } else {
            while(current != null && counter < n) {
                current = current.next;
                counter++;
            }
        }
        return current.data;
    }

    public static int countNodes(Node head) {
        int count = 1;
        Node current = head;
        while(current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}