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
public class RabinKarpSubstringSearch {
    public final static int d = 256;
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }
    public static void main(String[] args) {
        String txt = "ABCADCBABABCDABCDABDE";
        String pat = "BCD";
        int q = 101;
        search(pat, txt, q);
    }
}
