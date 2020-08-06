/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework6;

import java.util.Arrays;

/**
 *
 * @author aelinadas
 */
public class CountingSort {
    public static void sort(String str){
        char[] output = str.toCharArray();
        Arrays.sort(output);
        System.out.println(String.valueOf(output));
    }
    public static void main(String[] args) {
        
        String s = "ABDCEDDFCABBEECCEFDDAAF";
        sort(s);
        
    }
}
