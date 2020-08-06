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
public class PixelQuick {
    
     static void sort(double[] inputArray, int intialIndex, int finalIndex) {
        if (intialIndex < finalIndex) {
            double pivot = inputArray[intialIndex];
            int i = intialIndex;
            int j = finalIndex;
            while (i < j) {
                i += 1;
                while (i <= finalIndex && inputArray[i] > pivot) {
                    i += 1;
                }
                while (j >= intialIndex && inputArray[j] < pivot) {
                    j -= 1;
                }
                if (i <= finalIndex && i < j) {
                    swap(inputArray, i, j);
                }
            }
            swap(inputArray, intialIndex, j);
            sort(inputArray, intialIndex, j - 1);
            sort(inputArray, j + 1, finalIndex);
        }
    }

    static void swap(double[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
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
            sort(toBeSorted, 0, arrayList.size() - 1);
            for (int j = 0; j < toBeSorted.length; j++) {
                System.out.println(toBeSorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }

    }
    
}
