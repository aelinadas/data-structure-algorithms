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
public class FindMinimum {
    static Node head; 
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;
        root = tree.insert(root, 4); 
        tree.insert(root, 2); 
        tree.insert(root, 1); 
        tree.insert(root, 3); 
        tree.insert(root, 6); 
        tree.insert(root, 5);
        
        System.out.println("Minimum value of BST is " + tree.minValue(root));     
    } 
}
