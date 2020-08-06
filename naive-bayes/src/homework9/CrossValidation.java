/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework9;
/**
 *
 * @author aelinadas
 */
public class CrossValidation {
    
    public final int k;  
    public final int[][] train;  
    public final int[][] test;

    public CrossValidation(int n, int k) {
        this(n, k, true);
    }
    
    public int[] permutate(int n) {
	int[] x = new int[n];
	for (int i = 0; i < n; i++) {
            x[i] = i;
        }
        return permutate(n);
    }
    public CrossValidation(int n, int k, boolean permutate) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid sample size: " + n);
        }
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("Invalid number of CV rounds: " + k);
        }
        this.k = k;
        int[] index;
        if (permutate){
            index = permutate(n);
        }
        else{
            index = new int[n];
            for (int i = 0; i < n; i++) {
                index[i] = i;
            }
        }

        train = new int[k][];
        test = new int[k][];

        int chunk = n / k;
        for (int i = 0; i < k; i++) {
            int start = chunk * i;
            int end = chunk * (i + 1);
            if (i == k-1) end = n;
            train[i] = new int[n - end + start];
            test[i] = new int[end - start];
            for (int j = 0, p = 0, q = 0; j < n; j++) {
                if (j >= start && j < end) {
                    test[i][p++] = index[j];
                } else {
                    train[i][q++] = index[j];
                }
            }
        }
    }
    public static void main(String[] args) {
        CrossValidation cv = new CrossValidation(16, 8, false);
        
    }
}
