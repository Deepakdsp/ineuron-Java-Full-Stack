package com.ineuron.assignment1;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Ineuron {
    public static void main(String arg[]){
        int a=7;
        int k = 1;
        for(int i=0;i<=a;i++){

            for(int j=0;j<=a;j++){
                if(i==0|| j==a/2 || i==a){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("  ");

            for(int n=0;n<=a;n++){
                if(i==0 && n==0 || i==0 && n==a || n==0 || n==a || i==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("  ");

            for(int e=0;e<=a;e++){
                if(i==0 || e==0 || i==a/2 || i==a){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("  ");

            for(int u=0;u<=a;u++){
                if(i==0 && u==0 || u==a && i!=a || u==0 && i!=a || i==a && u!=0 && u!=a ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("  ");

            for(int r=0;r<=a;r++){
                if(r==0 || (i==0 || i==a/2) && r!=a || r==a && i<a/2 && i!=0 || i+r==k && r>=a/2 && i>a/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            k = k+2;

            System.out.print("  ");

            for(int o=0;o<=a;o++){
                if(i==0 && o!=a && o!=0 || i==a && o!=a && o!=0  || i!=0 && o==0 && i!=a || i!=0 && o==a && i!=a){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("  ");

            for(int n=0;n<=a;n++){
                if(i==0 && n==0 || i==0 && n==a || n==0 || n==a || i==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println(" ");
        }
    }
}
