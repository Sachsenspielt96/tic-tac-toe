package com.sachsenspielt;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Welcome Message

        System.out.println("#########################");
        System.out.println("Tic Tac Toe");
        System.out.println("#########################");
        System.out.println("Author: Sachsenspielt");
        System.out.println("Version: v1.0");
        System.out.println("Language: Java");
        System.out.println("©2020");
        System.out.println("#########################");
        System.out.println(" ");

        int[] Fields = new int[9];

        Fields[0] = 0;
        Fields[1] = 0;
        Fields[2] = 0;
        Fields[3] = 0;
        Fields[4] = 0;
        Fields[5] = 0;
        Fields[6] = 0;
        Fields[7] = 0;
        Fields[8] = 0;
        init(Fields);

    }

    public static void init(int[] Fields) throws IOException {
        //Init

        playground(Fields);
        System.out.println("It`s Player one's turn!");
        turnPlayerOne(Fields);
    }

    public static void turnPlayerOne(int[] Fields) throws IOException {

        int player = 1;
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if(input > 8 || input < 0) {
            System.out.println("Please enter a Number between 0 and 8");
            turnPlayerOne(Fields);
        }

        if(Fields[input] != 0) {
            System.out.println("This field is already used");
            turnPlayerOne(Fields);
        }

        Fields[input] = 1;

        //Checking Winner?
        checkWinner(player, Fields);

        playground(Fields);
        System.out.println("It`s Player two's turn!");
        turnPlayerTwo(Fields);
    }

    public static void turnPlayerTwo(int[] Fields) throws IOException {

        int player = 2;
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if(input > 8 || input < 0) {
            System.out.println("Please enter a Number between 0 and 8");
            turnPlayerTwo(Fields);
        }

        if(Fields[input] != 0) {
            System.out.println("This field is already used");
            turnPlayerTwo(Fields);
        }

        Fields[input] = 2;

        //Checking Winner?
        checkWinner(player, Fields);

        playground(Fields);
        System.out.println("It`s Player one's turn!");
        turnPlayerOne(Fields);
    }

    public static void playground(int[] Fields) {
        System.out.println(Fields[0] + "|" + Fields[1] + "|" + Fields[2]);
        System.out.println("-----");
        System.out.println(Fields[3] + "|" + Fields[4] + "|" + Fields[5]);
        System.out.println("-----");
        System.out.println(Fields[6] + "|" + Fields[7] + "|" + Fields[8]);
    }

    public static void checkWinner(int player, int[] Fields) {

        int winner;
        System.out.println("Checking winner... [" + player + "]");

        if(Fields[0] == player && Fields[1] == player && Fields[2] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[3] == player && Fields[4] == player && Fields[5] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[6] == player && Fields[7] == player && Fields[8] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[0] == player && Fields[3] == player && Fields[6] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[1] == player && Fields[4] == player && Fields[7] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[2] == player && Fields[5] == player && Fields[8] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[0] == player && Fields[4] == player && Fields[8] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

        if(Fields[2] == player && Fields[4] == player && Fields[6] == player) {
            winner = player;
            funcWinner(winner, Fields);
        }

    }

    public static void funcWinner(int winner, int[] Fields) {
        playground(Fields);
        System.out.println("Player " + winner + " win!");
        System.exit(0);
    }
}
