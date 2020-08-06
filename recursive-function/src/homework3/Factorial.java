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
public class Factorial {
    public static int factorial(int num){
        if(num == 1){
            return 1;
        }else{
            return (num * factorial(num - 1));
        }
    }
    public static void main(String[] args){
        int i;
        int fact = 1;
        int number = 6;
        fact = factorial(number);
        System.out.println("Factorial of " + number + " is:" + fact);
        
    }
}
// Time Complexity O(N)

