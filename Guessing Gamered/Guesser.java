package com.ineuron.java;

import java.util.Scanner;

class Guesser
{
    int gnum;

    int guessNum()
    {
        System.out.println("Guesser! Kindly guess a number between 1 to 100");
        Scanner kb=new Scanner(System.in);
        gnum=kb.nextInt();
        return gnum;
    }

    int guessNum(int low,int high)
    {
        System.out.println("Guesser! Kindly guess a number between "+low+"to"+high);
        Scanner kb=new Scanner(System.in);
        gnum=kb.nextInt();
        if(gnum >=low && gnum <=high)
        {
            return gnum;
        }
        else
        {
            System.out.println("Please guess a valid number within the range specified");
            return guessNum(low,high);
        }
    }
}
class Player
{
    int pnum;
    int predictNum(int low,int high)
    {
        System.out.println("Player! Kindly predict a number between "+low+"to"+high);
        Scanner kb=new Scanner(System.in);
        pnum=kb.nextInt();
        if(pnum >=low && pnum <=high)
        {
            return pnum;
        }
        else
        {
            System.out.println("Please guess a valid number within the range specified");
            return predictNum(low,high);
        }
    }
}
class Umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    void collectNumFromGuesser()
    {
        Guesser g=new Guesser();
        numFromGuesser=g.guessNum();
    }
    void collectNumFromPlayers()
    {
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();

        numFromPlayer1=p1.predictNum(1,100);
        numFromPlayer2=p2.predictNum(1,100);
        numFromPlayer3=p3.predictNum(1,100);
    }
    void compare()
    {
        if(numFromGuesser==numFromPlayer1)
        {
            System.out.println("Player1 wins it");
        }
        if(numFromGuesser==numFromPlayer2)
        {
            System.out.println("Player2 wins it");
        }
        if(numFromGuesser==numFromPlayer3)
        {
            System.out.println("Player3 wins it");
        }
        else
        {
            System.out.println("Game lost! Try Again");
        }
    }
}
class GuesserGameApp
{
    final static int CHANCES = 3;
    public static void main(String args[])
    {
        Umpire u= new Umpire();
        u.collectNumFromGuesser();
        int i=1;
        while(i<=CHANCES)
        {
            u.collectNumFromPlayers();
            u.compare();
            ++i;
        }
    }
}