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
public class TowerOfHanoi {
    public static void tower(int n, char from, char middle, char to){
        if(n == 1){
            System.out.println("Move disc 1 from " + from + " to " + to);
            
        }else{
            tower(n-1, from, to, middle);
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            tower(n-1, middle, from, to);           
        }
    }
    public static void main(String[] args) {
        int n = 5;
        char A, B ,C;
        tower(n, 'A', 'B', 'C');
    }
    
}
