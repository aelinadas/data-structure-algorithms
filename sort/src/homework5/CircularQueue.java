/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

/**
 *
 * @author aelinadas
 */
public class CircularQueue {
    
    private int[] queueRep;
    private int size, front, rear;
    private static final int CAPACITY = 16;

    public CircularQueue (){
     queueRep = new int [CAPACITY];
     size  = 0; front = 0; rear  = 0;
    }
 
    public CircularQueue (int cap){
     queueRep = new int [ cap];
     size  = 0; front = 0; rear  = 0;
    }

    public void enQueue (int data)throws NullPointerException, IllegalStateException{  
     if (size == CAPACITY)
      throw new IllegalStateException ("Queue is full: Overflow");
     else {
      size++;
      queueRep[rear] = data;
      rear = (rear+1) % CAPACITY;
     }
    }

    public int deQueue () throws IllegalStateException{
     if (size == 0)
      throw new IllegalStateException ("Queue is empty: Underflow");
     else {
      size--;
      int data = queueRep [ (front % CAPACITY) ];
      queueRep [front] = Integer.MIN_VALUE;
      front = (front+1) % CAPACITY;
      return data;
     }
    }

    public boolean isEmpty(){ 
     return (size == 0); 
    }

    public boolean isFull(){ 
     return (size == CAPACITY); 
    }

    public int size() {
     return size;
    }

    public String toString(){
     String result = "[";
     for (int i = 0; i < size; i++){
      result += Integer.toString(queueRep[ (front + i) % CAPACITY ]);
      if (i < size -1) {
       result += ", ";
      }
     }
     result += "]";
     return result;
    }

    public static void main(String[] args) {
        CircularQueue arrayQueue = new CircularQueue();
        arrayQueue.enQueue(7);
        arrayQueue.enQueue(28);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(9);
        arrayQueue.enQueue(12);
        arrayQueue.enQueue(82);
        arrayQueue.enQueue(10);
        arrayQueue.enQueue(31);
        arrayQueue.enQueue(24);
       
        System.out.println(arrayQueue.toString());
    }
}
