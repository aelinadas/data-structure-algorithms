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
public class ArrayObj {
     
    int size;
    Node a[];
    int i = 0;
    
    public ArrayObj(int size) {
        this.size = size;
        a = new Node[size];       
    }
    
    public class Node{
        int num;
        String name;

        Node(int num , String name) {
            this.num=num;
            this.name=name;
        }
    }
   
    public void push(Node n){       
        if(i != size){           
            a[i]=n;
            i++;
        }
    }
    
    public void pop(){
        if(size == 0){
            System.out.println("Empty Stack");
        }else{
            i = i-1;
        }
    }
    
    public int size(){
        return size;
    }
    
    public void print() 
    {
        if (i == 0) { 
            System.out.println("Stack Underflow");         
        } 
        else { 
            int j = i-1;             
            while  (j>=0) {
                Node temp = a[j];
                System.out.print("{" + temp.num + "," + temp.name + "}");
                System.out.print(" ");
                j = j-1; 
            } 
        } 
    } 
}
