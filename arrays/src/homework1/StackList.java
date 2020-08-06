/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author aelinadas
 */
public class StackList{
    private Node head = null;
    public int size = 0;

    private class Node {
        int n;
        String s;
        Node next;
    }
    public boolean isEmpty(){
        return head == null;
        
    }
    public void push(int num, String str){
        Node oldhead = head;
        head = new Node();
        head.n = num;
        head.s = str;
        head.next = oldhead;
        size++;
    }
    
    public Node pop(){
        int num = head.n;
        String item = head.s;
        head = head.next; 
        size--;
        return head;  
    }
    
    public int size(){
        return size;
    }
    
    public void print() 
    {
        if (head == null) { 
            System.out.println("Stack Underflow");         
        } 
        else { 
            Node temp = head; 
            while (temp != null) {
                System.out.print("{" + temp.n + "," + temp.s + "}");
                System.out.print(" ");
                temp = temp.next; 
            } 
        } 
    } 
    
    public static void main(String [] args){
        StackList list = new StackList();
        list.push(31, "Name1");
        list.push(24, "Name2");
        list.push(10, "Name3");
        list.push(44, "Name4");
        list.push(81, "Name5");
        list.push(33, "Name6");
        list.print();
        System.out.println();
        list.pop();
        list.print();
    }
    
}
