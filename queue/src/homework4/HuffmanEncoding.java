/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
 *
 * @author aelinadas
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffNode {

    char c;
    int frequency;
    HuffNode left = null;
    HuffNode right = null;

    HuffNode(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public HuffNode(char c, int frequency, HuffNode left, HuffNode right) {
        this.c = c;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
};

class HuffmanEncoding {

    public static void encode(HuffNode root, String input, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.c, input);
        }
        encode(root.left, input + "0", huffmanCode);
        encode(root.right, input + "1", huffmanCode);
    }

    public static void generateCode(String inputString) {
        Map<Character, Integer> frequence = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (!frequence.containsKey(inputString.charAt(i))) {
                frequence.put(inputString.charAt(i), 0);
            }
            frequence.put(inputString.charAt(i), frequence.get(inputString.charAt(i)) + 1);
        }

        PriorityQueue<HuffNode> priorityQueue = new PriorityQueue<>((l, r) -> l.frequency - r.frequency);
        for (Map.Entry<Character, Integer> entry : frequence.entrySet()) {
            priorityQueue.add(new HuffNode(entry.getKey(), entry.getValue()));
        }
        while (priorityQueue.size() != 1) {
            HuffNode left = priorityQueue.poll();
            HuffNode right = priorityQueue.poll();
            int sum = left.frequency + right.frequency;
            priorityQueue.add(new HuffNode('\0', sum, left, right));
        }
        HuffNode root = priorityQueue.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            stringBuilder.append(huffmanCode.get(inputString.charAt(i)));
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        String input = "It is a sunny day today";
        generateCode(input);
    }
}
