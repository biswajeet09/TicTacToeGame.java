package com.company;

// Tic tac toe game with options to play with computer or other user

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to TicTacToe ");
        System.out.println("For playing with Computer - Enter 1");
        System.out.println("For playing with other user - Enter 2");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        Gameboard ob = new Gameboard();
        ob.show();
        if (choice == 1) {
            Withcomputer ob3 = new Withcomputer();
            ob3.game();
        } else {
            Gameplay ob2 = new Gameplay();
            ob2.game();
        }
    }
}
