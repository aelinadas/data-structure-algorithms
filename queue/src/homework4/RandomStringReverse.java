/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import java.security.SecureRandom;

/**
 *
 * @author aelinadas
 */
public class RandomStringReverse {

    private static String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static String NUMBER = "0123456789";
    private static String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            System.out.println(generateString(500));
        }
    }

    public static String generateString(int length) {
        String randomString = "";
        String reverseString = "";
        for (int i = 0; i < length; i++) {
            int randomCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char randomChar = DATA_FOR_RANDOM_STRING.charAt(randomCharAt);
            randomString += randomChar;
        }
        for (int i = randomString.length() - 1; i >= 10; i--) {
            reverseString += randomString.charAt(i);
        }
        return reverseString;
    }
}
