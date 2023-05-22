package com.ineuron.assignment1;

public class PatternFour {
    public static void main(String[] args) {
        int n = 8;

        System.out.println();

        int i, j = 0;

        // for top half
        for (i = 0; i < n; i++) {

            // for left *
            for (j = i; j < n; j++)
                if (i == n - 1) {
                    System.out.print("*");
                }

            // for middle " "
            for (j = 0; j < 2 * i + 1; j++)
                if (i != n || i != n - 1) {
                    System.out.print(" ");
                }

            // for right *
            for (j = i; j < n; j++)
                if (i == n - 1) {
                    System.out.print("* ");
                }
            System.out.println();
        }

        for (i = 0; i < n - 1; i++) {

            // for left *
            for (j = 0; j < i + 2; j++) {
                System.out.print("*");
            }

            // for middle " "
            for (j = 0; j < 2 * (n - 1 - i) - 1; j++) {
                System.out.print(" ");
            }

            // for right *
            for (j = 0; j < i + 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(i=0; i<=n*2; i++){
            for(j=0;j<=n*2;j++){
                if(i==0 || i==1){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
