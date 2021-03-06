package de.sachsenspielt.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int width = 650;
    public static int height = 900;
    public static int[] Fields = new int[9];
    public static int player;

    public static void main(String[] args) throws IOException {

        //Welcome Message

        System.out.println("#########################");
        System.out.println("Tic Tac Toe");
        System.out.println("#########################");
        System.out.println("Author: Sachsenspielt");
        System.out.println("Version: v1.2");
        System.out.println("Language: Java");
        System.out.println("©2020");
        System.out.println("#########################");
        System.out.println(" ");

        init(Fields);

    }

    public static void init(int[] Fields) throws IOException {


        Fields[0] = 0;
        Fields[1] = 1;
        Fields[2] = 2;
        Fields[3] = 3;
        Fields[4] = 4;
        Fields[5] = 5;
        Fields[6] = 6;
        Fields[7] = 7;
        Fields[8] = 8;


        System.out.println("The playground: (Numbers represent the Field ID)");
        playground(Fields);
        System.out.println(" ");
        System.out.println("It`s Player one's turn!");

        Arrays.fill(Fields, 0);
        turnPlayerOne(Fields);

    }

    public static void turnPlayerOne(int[] Fields) throws IOException {

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

        player = 1;
        checkWinner(player, Fields);

        playground(Fields);
        System.out.println("It`s Player two's turn!");
        turnPlayerTwo(Fields);
    }

    public static void turnPlayerTwo(int[] Fields) throws IOException {

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

        //Checking Winner?

        Fields[input] = 2;

        player = 2;
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

    public static void checkWinner(int player, int[] Fields) throws IOException {
        int winner;

        if(Fields[0] == player && Fields[1] == player && Fields[2] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[3] == player && Fields[4] == player && Fields[5] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[6] == player && Fields[7] == player && Fields[8] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[0] == player && Fields[3] == player && Fields[6] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[1] == player && Fields[4] == player && Fields[7] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[2] == player && Fields[5] == player && Fields[8] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[0] == player && Fields[4] == player && Fields[8] == player) {
            winner = player;
            winner(winner, Fields);
        }

        if(Fields[2] == player && Fields[4] == player && Fields[6] == player) {
            winner = player;
            winner(winner, Fields);
        }
    }

    public static void winner(int winner, int[] Fields) throws IOException {
        Scanner input = new Scanner(System.in);

        playground(Fields);
        System.out.println("Player " + winner + " win!");
        System.out.println(" ");
        System.out.println("For restart type 'restart'!");

        String in = input.nextLine();

        if (in.toLowerCase().equals("restart")) {
            init(Fields);
            return;
        } else {
            System.exit(0);
        }
    }
}
