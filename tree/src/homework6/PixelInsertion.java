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
public class PixelInsertion {
    
    void sort(double input[]) {
        for (int i = 1; i < input.length; ++i) {
            double key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] < key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        BufferedImage image;
        int width;
        int height;
        ArrayList<Double> arrayList = new ArrayList();
        PixelInsertion pixelInsertion = new PixelInsertion();
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
            pixelInsertion.sort(toBeSorted);
            for (int j = 0; j < toBeSorted.length; j++) {
                System.out.println(toBeSorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }
    
}
