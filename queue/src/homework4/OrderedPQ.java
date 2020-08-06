/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import java.util.PriorityQueue;

/**
 *
 * @author aelinadas
 */
public class OrderedPQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> in = new PriorityQueue<>();
        in.add(3);
        in.add(10);
        in.add(5);
        in.add(12);
        in.add(20);
        in.add(9);
        in.add(41);
        in.add(6);
        in.add(11);
        in.add(50);
        in.add(24);
        in.add(14);
        while (!in.isEmpty()) {
            System.out.println(in.remove());
        }
    }
}
