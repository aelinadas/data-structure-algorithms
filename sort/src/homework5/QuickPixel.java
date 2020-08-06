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
public class QuickPixel {
    static void quickSort(double[] inputArray, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            double pivot = inputArray[firstIndex];
            int i = firstIndex;
            int j = lastIndex;
            while (i < j) {
                i += 1;
                while (i <= lastIndex && inputArray[i] < pivot) {
                    i += 1;
                }
                while (j >= firstIndex && inputArray[j] > pivot) {
                    j -= 1;
                }
                if (i <= lastIndex && i < j) {
                    quickSwap(inputArray, i, j);
                }
            }
            quickSwap(inputArray, firstIndex, j);
            quickSort(inputArray, firstIndex, j - 1);
            quickSort(inputArray, j + 1, lastIndex);
        }
    }

    static void quickSwap(double[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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
            quickSort(sorted, 0, in.size() - 1);
            for (int j = 0; j < sorted.length; j++) {
                System.out.println(sorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }

    }
    
}
