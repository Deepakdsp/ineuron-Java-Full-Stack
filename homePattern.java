package com.ineuron.assignment1;

public class homePattern {
    public static void main(String arg[]){
        int n=13;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
               if(i==0 || j==0 || i==n || j==n || i+j<= n/2 || j-i>=n/2){
                    System.out.print("* ");
               }else{
                   System.out.print("  ");
               }
            }
            System.out.println("");
        }
    }
}
