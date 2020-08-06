/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework6;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author aelinadas
 */
public class PixelTim {
    static int RUN = 32;
    
    public static void insertionSort(double[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            double temp = arr[i];
            int j = i - 1;
            while (arr[j] > temp && j >= left) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void merge(double[] arr, int l,
            int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        double[] left = new double[len1];
        double[] right = new double[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    
    public static void timSort(double[] arr, int n) {
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                merge(arr, left, mid, right);
            }
        }
    }

    public static void printArray(double [] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        BufferedImage image;
        int width;
        int height;
        ArrayList<Double> arrayList = new ArrayList();
        try {
            File input = new File("/Users/aelinadas/Downloads/1st Sem/Assignment- 6205/image.png");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    double intensity = (0.2989 * c.getRed() + 0.5870 * c.getGreen() + 0.1140 * c.getBlue());
                    arrayList.add(intensity);
                }
            }
            double[] toBeSorted = new double[arrayList.size()];
            int i = 0;
            for (Double d : arrayList) {
                toBeSorted[i] = d;
                i++;
            }
            int n = toBeSorted.length;
            timSort(toBeSorted, n);
            printArray(toBeSorted, n);
            
        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }
    
}
