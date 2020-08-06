/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author aelinadas
 */
public class ReadBack {

    public static void main(String [] args){
        Stack<String> str = new Stack<String>();
        str.push("It");
        str.push("was");
        str.push("the");
        str.push("best");
        str.push("of");
        str.push("time");
        Iterator<String> newStr = str.iterator();
        while(newStr.hasNext()){
           String rev = str.pop();
           System.out.print(rev + " ");  
        }
        
    }
}
