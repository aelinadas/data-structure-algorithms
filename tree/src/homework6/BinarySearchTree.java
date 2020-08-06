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
public class BinarySearchTree {
    static Node root;

    public BinarySearchTree(){
        root = null;
    }
    
    void deleteKey(int key){ 
        root = deleteRec(root, key); 
    }
    
    Node deleteRec(Node root, int key){ 
        if (root == null)  return root;
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
        else
        {
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            root.key = minValue(root.right); 
            root.right = deleteRec(root.right, root.key); 
        } 
        return root; 
    } 
    
    int minValue(Node root){ 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
    
    static int max(Node node){ 
        if (node == null) 
            return Integer.MIN_VALUE; 
  
        int res = node.key; 
        int lres = max(node.left); 
        int rres = max(node.right); 
  
        if (lres > res) 
            res = lres; 
        if (rres > res) 
            res = rres; 
        return res; 
    } 
    
    static int maxValue(Node node) 
    {
        Node current = node; 
        while (current.right != null){  
            current = current.right; 
        }
      
        return (current.key); 
    } 
    
    Node insertRec(Node root, int key){ 
        if (root == null) { 
            root = new Node(key); 
            return root; 
        }if (key <= root.key) 
            root.left = insertRec(root.left, key); 
        else if (key >= root.key) 
            root.right = insertRec(root.right, key);
        return root; 
    } 

    void insert(int key){
        root = insert(root, key);
    }
    
    Node insert(Node node, int data){
         if(node == null){
             return (new Node(data));
         }else{
             if(data <= node.key){
                 node.left = insert(node.left, data);
                 
             }else{
                 node.right = insert(node.right, data);
             }
         }
         return node;
    }
    
    void inorderRec(Node root){ 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
    }
    
    void inorder(){ 
       inorderRec(root); 
    } 
     
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(42);
        bt.insert(12);
        bt.insert(53);
        bt.insert(8);
        bt.insert(16);
        bt.insert(60);
        bt.insert(2);
        bt.insert(22);
        bt.insert(57);
        bt.insert(65);
        bt.insert(19);
        bt.inorder();
        System.out.println(); 
        
        bt.deleteKey(65);
        bt.deleteKey(60);
        bt.deleteKey(42);
        bt.inorder();
        System.out.println(); 
        
        BinarySearchTree ques5 = new BinarySearchTree();
        ques5.insert(30);
        ques5.insert(40);
        ques5.insert(23);
        ques5.insert(58);
        ques5.insert(48);
        ques5.insert(26);
        ques5.insert(11);
        ques5.insert(13);
        bt.inorder();
    }
}
