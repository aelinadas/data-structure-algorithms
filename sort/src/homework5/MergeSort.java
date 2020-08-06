/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.util.Arrays;

/**
 *
 * @author aelinadas
 */
public class MergeSort {
    
    
    public static int[] leftHalf(int[] arr){
       int size1 = arr.length/2;
       int[] left = new int[size1];
       for(int i=0; i < size1; i++){
           left[i] = arr[i];
       }
       return left;
    }
    
    public static int[] rightHalf(int[] arr){
        int size1 = arr.length/2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for(int i =0; i < size2; i++){
            right[i]= arr[i + size1];
        }
        return right;
    }
    
    
    public static void merge(int[] res, int[] left, int[] right){
        int i1 = 0;
        int i2 = 0;
        for(int i = 0; i < res.length; i++){
            if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])){
                res[i] = left[i1];
                i1++;
            }else{
                res[i] = right[i2];
                i2++;
            }
        }
    }
    
    public static void mergeSort(int[] arr){
        if(arr.length > 1){
            int left[] = leftHalf(arr);
            int right[] = rightHalf(arr);
            mergeSort(left);
            mergeSort(right);
            
            merge(arr, left, right);
        }
    }
    
    public static void main(String[] args) {
        int[] in = {27, 43, 38, 3, 9, 82, 10, 33, 19, 15};
        System.out.println("Before merge sort:" + Arrays.toString(in));
        mergeSort(in);
        System.out.println("After merge sort:" + Arrays.toString(in));
        
    }
    
}
