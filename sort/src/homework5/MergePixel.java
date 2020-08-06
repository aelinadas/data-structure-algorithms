/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author aelinadas
 */
public class MergePixel {
    static void mergeSort(double arr[], int firstIndex, int middleIndex, int lastIndex) {
        int arr1Size = middleIndex - firstIndex + 1;
        int arr2Size = lastIndex - middleIndex;

        double arr1[] = new double[arr1Size];
        double arr2[] = new double[arr2Size];
        for (int i = 0; i < arr1Size; ++i) {
            arr1[i] = arr[firstIndex + i];
        }
        for (int j = 0; j < arr2Size; ++j) {
            arr2[j] = arr[middleIndex + 1 + j];
        }

        int i = 0, j = 0;
        int k = firstIndex;
        while (i < arr1Size && j < arr2Size) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1Size) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2Size) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    static void sort(double input[], int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            sort(input, firstIndex, middleIndex);
            sort(input, middleIndex + 1, lastIndex);
            mergeSort(input, firstIndex, middleIndex, lastIndex);
        }
    }

    public static void main(String[] args) {
        BufferedImage img;
        int wid;
        int hgt;
        ArrayList<Double> in = new ArrayList();

        try {
            File input = new File("/Users/aelinadas/Downloads/1st Sem/Assignment- 6205/image.png");
            img = ImageIO.read(input);
            wid = img.getWidth();
            hgt = img.getHeight();
            for (int i = 0; i < hgt; i++) {
                for (int j = 0; j < wid; j++) {
                    Color c = new Color(img.getRGB(j, i));
                    double intensity = (0.2989 * c.getRed() + 0.5870 * c.getGreen() + 0.1140 * c.getBlue());
                    in.add(intensity);
                }
            }
            double[] sorted = new double[in.size()];
            int i = 0;
            for (Double d : in) {
                sorted[i] = d;
                i++;
            }
            sort(sorted, 0, in.size() - 1);
            for (int j = 0; j < sorted.length; j++) {
                System.out.println(sorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }  
}
