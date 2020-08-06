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
public class ResizeArray {
    
    int size;
    Node a[];
    int i = 0;
    
    public ResizeArray(int size) {
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
        if(size == i){
            memoryadd();
            a[i]=n;
            i++;
        }
        else{
            a[i]=n;
            i++;
        }
    }
    
    public void pop(){
        if(i == 0){
            System.out.println("Stack Underflow");
        }else{
            i = i-1;
            memorysub();
        }
    }
    
    public int size(){
        return size;
    }
    
    public void print() 
    {
        if (i < 0) { 
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
    
    public void memoryadd(){
        if(size == i){
            Node[] newArr = new Node[size*2];
            for(int k=0; k < size; k++){
                newArr[k] = a[k];
            }
            size = size*2;
            a = newArr;
        }    
    }
    
    public void memorysub(){
        if(i == (size/2)/2){
            size = size/2;
            Node[] newArrSub = new Node[size];
            for(int k=0; k < size; k++){
                newArrSub[k] = a[k];
            }      
        a = newArrSub;
        }
    }
}
