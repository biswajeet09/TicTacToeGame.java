package com.company;


import java.util.Scanner;

public class Player {
    char sym;
    String name1, name2,turn,k;
    // To get the player's name
    public void playid() {
        System.out.println("Enter 1st player name");
        Scanner s = new Scanner(System.in);
        name1 = s.nextLine();
        System.out.println("Enter 2nd player name");
        Scanner sc = new Scanner(System.in);
        name2 = sc.nextLine();
        turn=name1;
    }
    // To show whose turn and to set their symbol(O or X)
    public String whoseturn() {
        if (turn.equals(name1)) {
            sym='X';
            System.out.println(name1 + " turn");
            turn=name2;
            k=name1;
        }
        else {
            sym='O';
            System.out.println(name2 + " turn");
            turn=name1;
            k=name2;
        }
        return k;
    }
}

