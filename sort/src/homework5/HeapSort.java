/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

/**
 *
 * @author aelinadas
 */
public class HeapSort {
 
    static void heapify(int arr[], int n, int i){
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < n && arr[l] < arr[smallest]){ 
            smallest = l; 
        }if (r < n && arr[r] < arr[smallest]){
            smallest = r; 
        }if (smallest != i){ 
            int temp = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = temp; 
            heapify(arr, n, smallest); 
        }
    }
    
    static void heapSorting(int arr[], int n){
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
    
    static void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String[] args) 
    { 
        int in[] = {27, 43, 38, 3, 9, 82, 10, 33, 19, 15}; 
        int n = in.length; 
  
        heapSorting(in, n); 
  
        System.out.println("Sorted array is "); 
        printArray(in, n); 
    } 
}
