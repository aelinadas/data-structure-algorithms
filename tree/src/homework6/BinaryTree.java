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
class BinaryTreeNode {

    BinaryTreeNode left, right;
    int data;

    public BinaryTreeNode() {
        left = null;
        right = null;
        data = 0;
    }

    public BinaryTreeNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinaryTreeNode n) {
        left = n;
    }

    public void setRight(BinaryTreeNode n) {
        right = n;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}

class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode getRoot() {
        if (root != null) {
            return root;
        }
        return null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            if (node.getRight() == null) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(BinaryTreeNode r, int val) {
        if (r.getData() == val) {
            return true;
        }
        if (r.getLeft() != null) {
            if (search(r.getLeft(), val)) {
                return true;
            }
        }
        if (r.getRight() != null) {
            if (search(r.getRight(), val)) {
                return true;
            }
        }
        return false;
    }

    public int findMax(BinaryTreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int result = node.data;
        int leftResult = findMax(node.left);
        int rightResult = findMax(node.right);

        if (leftResult > result) {
            result = leftResult;
        }
        if (rightResult > result) {
            result = rightResult;
        }
        return result;
    }

    static int findMin(BinaryTreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int result = node.data;
        int leftResult = findMin(node.left);
        int rightResult = findMin(node.right);

        if (leftResult < result) {
            result = leftResult;
        }
        if (rightResult < result) {
            result = rightResult;
        }
        return result;
    }
    
    public void preorder()
     {
         preorder(root);
     }
     private void preorder(BinaryTreeNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    BinaryTreeNode deleteRec(BinaryTreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        System.out.println("Deleted " + key);
        return root;
    }

    int minValue(BinaryTreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    BinaryTreeNode deleteMax(BinaryTreeNode rootNode) {
        int max = findMax(rootNode);
        deleteKey(max);
        return rootNode;
    }

    BinaryTreeNode deleteMin(BinaryTreeNode rootNode) {
        int min = findMin(rootNode);
        deleteKey(min);
        return rootNode;
    }
}