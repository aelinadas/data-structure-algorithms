/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework6;

/**
 *
 * @author aelinadas
 */
public class MaximumBinarySearchTree {
    
    static class node {

        char data;
        node left;
        node right;
    };

    static node newNode(char data) {
        node node = new node();
        node.data = data;
        node.left = null;
        node.right = null;

        return (node);
    }

    static node insert(node node, char data) {
        if (node == null) {
            return (newNode(data));
        } else {
            if (Character.compare(data, node.data) >= 0) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
            return node;
        }
    }

    static char maxValue(node node) {
        if (node.right == null) {
            return node.data;
        }
        return maxValue(node.right);
    }

    public static void main(String args[]) {

        node root = null;
        root = insert(root, 'A');
        root = insert(root, 'B');
        root = insert(root, 'C');
        root = insert(root, 'D');
        root = insert(root, 'E');
        root = insert(root, 'F');
        root = insert(root, 'G');
        root = insert(root, 'H');
        root = insert(root, 'I');
        root = insert(root, 'J');
        root = insert(root, 'K');

        System.out.println(maxValue(root));

    }
}
