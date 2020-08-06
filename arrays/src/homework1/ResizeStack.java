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
public class ResizeStack {
    public static void main(String [] args){
        ResizeArray obj = new ResizeArray(4);
        ResizeArray.Node one=obj.new Node(31,"Name1");
        obj.push(one);
        ResizeArray.Node two=obj.new Node(24,"Name2");
        obj.push(two);
        ResizeArray.Node three=obj.new Node(10,"Name3");
        obj.push(three);
        ResizeArray.Node four=obj.new Node(44,"Name4");
        obj.push(four);
        ResizeArray.Node five=obj.new Node(81,"Name5");
        obj.push(five);
        obj.pop();
        obj.print();
        System.out.println();
        obj.pop();
        obj.print();
    }
}
