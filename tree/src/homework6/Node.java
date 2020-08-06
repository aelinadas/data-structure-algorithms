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
public class Node {
    int key;
    Node left;
    Node right;
    
    Node(int item){
        key = item;
        this.left = null;
        this.right = null;
    }
}
