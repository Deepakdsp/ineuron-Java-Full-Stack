package com.ineuron.assignment1;

public class FivePattern {

    public static void main(String[] arg) {

        int i, j, n = 10;

        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                if(i==n){
                System.out.print("* " + " ");
                }
            }
        }
        System.out.println();


        for (i = n/2; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("* " + " ");
            }
            System.out.println();
        }

        for (i = 2; i <= n/2; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("* " + " ");
            }
            System.out.println();
        }

        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                if(i==n){
                    System.out.print("* " + " ");
                }
            }
        }
    }
}
