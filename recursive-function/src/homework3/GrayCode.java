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
public class GrayCode {
    public static void yarg(String prefix, int n) {
        
        if (n == 0) {
            System.out.print(prefix + ", ");
        }else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  

    public static void gray(String prefix, int n) {
        if (n == 0){
            System.out.print(prefix + ", ");
        }else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        gray("", 4);
    }   
}
