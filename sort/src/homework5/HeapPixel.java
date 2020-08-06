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
public class HeapPixel {
    
    static void heapify(double inputArray[], int len, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < len && inputArray[l] > inputArray[largest]) {
            largest = l;
        }
        if (r < len && inputArray[r] > inputArray[largest]) {
            largest = r;
        }
        if (largest != i) {
            double temp = inputArray[i];
            inputArray[i] = inputArray[largest];
            inputArray[largest] = temp;
            heapify(inputArray, len, largest);
        }
    }

    static void heapSort(double inputArray[], int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            double temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;
            heapify(inputArray, i, 0);
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
            heapSort(sorted, sorted.length);
            for (int j = 0; j < sorted.length; j++) {
                System.out.println(sorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }

    
}
