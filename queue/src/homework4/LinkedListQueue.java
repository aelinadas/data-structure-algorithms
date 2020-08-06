/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
 *
 * @author aelinadas
 */
public class LinkedListQueue {

    NodeQueue head;
    NodeQueue tail;
    private int size = 0;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int number) {
        NodeQueue temp = new NodeQueue(number);
        if (tail == null) {
            this.head = temp;
            this.tail = temp;
            size++;
        } else {
            tail.next = temp;
            tail = temp;
            size++;
        }
    }

    public NodeQueue dequeue() {
        NodeQueue temp;
        if (head == null) {
            return null;
        }
        temp = head;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
    
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        System.out.println("Queue before enqueue: " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Queue Size " + queue.size());
        System.out.println("Queue after dequeue: " + queue.isEmpty());
        System.out.println("De-queued item is: " + queue.dequeue().number);
        System.out.println("Queue Size " + queue.size());
    }

}
