/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework10;

/**
 *
 * @author aelinadas
 */
public class BruteForceSubstringSearch {

    public static void bfSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
    public static void main(String[] args) {
        String txt = "ABCADCBABABCDABCDABDE";
        String pat = "BCD";
        bfSearch(txt, pat);
    }
}
