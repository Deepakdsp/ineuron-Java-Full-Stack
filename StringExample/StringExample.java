package com.ineuron.assignment3;

import java.util.Arrays;
import java.util.Scanner;

class ReverseString {

    void getReverseString() {
        StringBuilder input1 = new StringBuilder();
        String reverseStringValue = "iNeuron";
        input1.append(reverseStringValue);
        System.out.println("Before Reverse String = " + reverseStringValue);
        System.out.println("After Reverse String = " + input1.reverse());
    }

    void getSentenceReverseString() {
        String sentenceToBeReverse = "Think Twice";
        String[] words = sentenceToBeReverse.split("\\s");
        String reverseWord = "";
        for (String w : words) {
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWord += sb + " ";
        }
        System.out.println("Before Reverse String = " + sentenceToBeReverse);
        System.out.println("After Reverse String = " + reverseWord.trim());
    }

    void getCheckAnagramString(String str1, String str2) {

        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }

    void getPangramString(String str) {
        boolean[] alphaList = new boolean[26];
        int index = 0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';
            }
            alphaList[index] = true;
        }
        for (int i = 0; i <= 25; i++) {
            if (alphaList[i] == false)
                flag = 0;
        }
        System.out.print("String: " + str);
        if (flag == 1)
            System.out.print("\nThe above string is a pangram.");
        else
            System.out.print("\nThe above string is not a pangram.");
    }

    void getDuplicateCharacter(String str) {
        final int MAX_CHAR = 256;

        int[] count = new int[MAX_CHAR];

        int len = str.length();

        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        // Create an array of given String size
        char[] ch = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)
                System.out.println(
                        "Number of Occurrence of "
                                + str.charAt(i)
                                + " is:" + count[str.charAt(i)]);
        }
    }

    void getSortedAlphabet(String str){
        char charArray[] = str.toCharArray();
        Arrays.sort(charArray);
        System.out.println(new String(charArray));
    }

    void getVowelsAndConsoants(){
        int vCount = 0, cCount = 0;

        String str = "This is a really simple sentence";
        str = str.toLowerCase();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vCount++;
            }
            else if(str.charAt(i) >= 'a' && str.charAt(i)<='z') {
                cCount++;
            }
        }
        System.out.println("Number of vowels: " + vCount);
        System.out.println("Number of consonants: " + cCount);
    }

    void getSpecialCharacter(){
        String aldisp_str;
        int i, alph, digi, spl;
        alph = digi = spl = 0;
        char ch;

        aldisp_str = "@inurone#1To$%JavaDevel0per";

        for(i = 0; i < aldisp_str.length(); i++)
        {
            ch = aldisp_str.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' ) {
                alph++;
            }
            else if(ch >= '0' && ch <= '9') {
                digi++;
            }
            else {
                spl++;
            }
        }
        System.out.println("\nNumber of Alphabet Characters  =  " + alph);
        System.out.println("Number of Digit Characters     =  " + digi);
        System.out.println("Number of Special Characters   =  " + spl);
    }
}

public class StringExample {
    public static void main(String[] arg) {
        ReverseString reverseObj = new ReverseString();
        System.out.println("================ Assignment 3 Quest 1 ==============");
        reverseObj.getReverseString();
        System.out.println("================ Assignment 3 Quest 2 ==============");
        reverseObj.getSentenceReverseString();
        System.out.println("================ Assignment 3 Quest 3 ==============");
        reverseObj.getCheckAnagramString("Keep", "Peek");
        reverseObj.getCheckAnagramString("Mother In Law", "Hitler Woman");
        System.out.println("================ Assignment 3 Quest 4 ==============");
        reverseObj.getPangramString("ABcdefghI jklmnopqerstu vwxyz22");
        reverseObj.getPangramString("Hi Navin ,Hyder ,Nitin sir");
        System.out.println("================ Assignment 3 Quest 5 ==============");
        reverseObj.getDuplicateCharacter("JavaDeveloper");
        System.out.println("================ Assignment 3 Quest 6 ==============");
        reverseObj.getSortedAlphabet("thisissort");
        System.out.println("================ Assignment 3 Quest 7 ==============");
        reverseObj.getVowelsAndConsoants();
        System.out.println("================ Assignment 3 Quest 8 ==============");
        reverseObj.getSpecialCharacter();

    }
}
