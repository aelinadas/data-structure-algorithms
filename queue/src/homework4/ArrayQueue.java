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
public class ArrayQueue {

    int head;
    int tail;
    int size;
    int[] array;

    public ArrayQueue(int size) {
        this.size = size;
        head = tail = 0;
        array = new int[size];
    }

    public void enqueue(int number) {
        if (tail != size) {
            array[tail] = number;
            tail++;
        }
    }

    public int dequeue() {
        int temp;
        if (head != tail) {
            temp = array[0];
            for (int i = 0; i < tail - 1; i++) {
                array[i] = array[i + 1];
            }
            if (tail < size) {
                array[tail] = 0;
            }
            tail--;
            return temp;
        }
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head == tail);
    }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println("Queue before enqueue: " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Queue after dequeue: " + queue.isEmpty());
        System.out.println("De-queued item is: " + queue.dequeue());

    }
}
