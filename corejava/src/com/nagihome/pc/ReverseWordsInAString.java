package com.nagihome.pc;

public class ReverseWordsInAString {

    public static String reverse(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        String input = "Hello World!!! This is Reverse Of a String";
//        System.out.printf("Output: %s\n", reverse(input));

        String input01 = "This Is Nagi";
        reverseWords(input01.toCharArray());

    }


    public static void reverseWords(char[] s) {
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }

        reverse(s, i, s.length - 1);
        reverse(s, 0, s.length - 1);
    }

    public static void reverse(char[] s, int i, int j) {
        while (i < j) {
            System.out.printf("i: %s, j: %s, s[i]: %s, s[j]: %s\n", i, j, s[i], s[j]);
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
