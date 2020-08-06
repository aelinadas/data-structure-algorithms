/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author aelinadas
 */
public class SumTripleLoop {
    
    public static void main(String[] args){
        int n = 10;
        int count = 0;
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                for(int k = j; k < n; k++ ){
                    count++;
                }
            }
        }
        System.out.println("Count:" + count);
    }
    
}
