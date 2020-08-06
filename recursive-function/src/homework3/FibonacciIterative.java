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
public class FibonacciIterative {
    
    public static void main(String[] args){
        int firstNum = 0;
        int nextNum = 1;
        int n = 5;
        int sum = 0;
        if(n == 0){
            System.out.println("0");
        }else if(n == 1 || n == 2){
            System.out.println("1");
        }else{
            for(int i = 1; i < n; i++){
                sum = firstNum + nextNum;
                firstNum = nextNum;
                nextNum = sum;
            }
            System.out.println("Sum is: " + sum);
        }
    }
    
}
