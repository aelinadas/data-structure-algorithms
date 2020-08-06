/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

/**
 *
 * @author aelinadas
 */
public class Fibonacci {
    public static int fib(int n){
        if(n <= 1){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }
    public static void main(String[] args){
        int n = 5;
        System.out.println("Fibonacci Sequence of " + n + " is: " + fib(n));
    }
            
}
