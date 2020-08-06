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
public class SumofDigits {
    
    public static int sumDigits(int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }else if(n == 0){
           return 0; 
        }
        else{
            return (n % 10 + sumDigits(n/10));
        }
    }
    
    public static void main(String[] args){
        int n = 26497;
        System.out.println("The sum of digits of " + n + " is: " + sumDigits(n));
    }
}
