/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;
import homework1.ArrayObj.Node;
/**
 *
 * @author aelinadas
 */
public class ArrayStack {
    
    public static void main(String [] args){
        ArrayObj obj = new ArrayObj(5);
        Node one=obj.new Node(31,"Name1");
        obj.push(one);
        Node two=obj.new Node(24,"Name2");
        obj.push(two);
        Node three=obj.new Node(10,"Name3");
        obj.push(three);
        Node four=obj.new Node(44,"Name4");
        obj.push(four);
        Node five=obj.new Node(81,"Name5");
        obj.push(five);
        obj.print();
        System.out.println();
        obj.pop();
        obj.print();
        
        
    }
    
}
