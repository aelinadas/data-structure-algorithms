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
public class BinaryTreeFunctions {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(9);
        binaryTree.insert(23);
        binaryTree.insert(45);
        boolean result = binaryTree.search(23);
        if (result) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
        System.out.println(binaryTree.findMax(binaryTree.getRoot()));
        System.out.println(binaryTree.findMin(binaryTree.getRoot()));
        binaryTree.deleteMax(binaryTree.getRoot());
        binaryTree.deleteMin(binaryTree.getRoot());

    }
}
