package com.kartashov;

public class Main {

    public static void main(String[] args) {
        Tree my_tree = new Tree();
        my_tree.insert(6, "Dima");
        my_tree.insert(45, "Vlad");
        my_tree.insert(3, "Sasha");
        my_tree.insert(7, "Lexa");

        Node founded_node = my_tree.find(6);
        founded_node.printNode();

        my_tree.print(founded_node);

    }
}
