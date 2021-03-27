package com.kartashov;

public class Tree {
    Node root;

    public Node find(int key) {
        Node current = root;
        while (current.key != key) {
            if (current.key < key) {
                current = current.left_child;
            } else {
                current = current.right_child;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key, String data) {
        Node node = new Node();
        node.key = key;
        node.data = data;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev = null;
            while (true) {
                prev = current;
                if (key < prev.key) {
                    current = current.left_child;
                    if (current == null) {
                        prev.left_child = node;
                        return;
                    }
                } else {
                    current = current.right_child;
                    if (current == null) {
                        prev.right_child = node;
                        return;
                    }
                }
            }
        }
    }

    public void print(Node start_node) {
        if (start_node != null) {
            print(start_node.left_child);
            start_node.printNode();
            print(start_node.right_child);
        }
    }
}
