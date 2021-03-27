package com.kartashov;

public class Node {

    public int key;
    public String data;
    public Node left_child;
    public Node right_child;

    public void printNode () {
        System.out.println("Key: " + key + " Data: " + data);
    }


}
