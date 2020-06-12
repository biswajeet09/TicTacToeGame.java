package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {
    private int box, m=0,n=0, i, j, count = 1;
    private char[][] board = new char[3][3];
    Player p1 = new Player();
    private ArrayList user1pos = new ArrayList();
    private ArrayList user2pos = new ArrayList();
    // To initialize the game
    public void game() {
        p1.playid();
        while (count <= 10) {
            if (count == 10) {
                System.out.println("The game Draw");
                break;
            }
            System.out.println("Game is on");
            p1.whoseturn();
            move();
            if (alcheck()) {
                break;
            }
            count++;
        }
    }

    // To display the current board status after every move
    private void display() {
        if (box == 9)
            board[2][2] = p1.sym;
        if (box == 8)
            board[2][1] = p1.sym;
        if (box == 7)
            board[2][0] = p1.sym;
        if (box == 6)
            board[1][2] = p1.sym;
        if (box == 5)
            board[1][1] = p1.sym;
        if (box == 4)
            board[1][0] = p1.sym;
        if (box == 3)
            board[0][2] = p1.sym;
        if (box == 2)
            board[0][1] = p1.sym;
        if (box == 1)
            board[0][0] = p1.sym;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board.length; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

    // To take the player's move
    private void move() {
        if (count % 2 != 0) {
            Scanner in = new Scanner(System.in);
            box = in.nextInt();
            while (user1pos.contains(box) || user2pos.contains(box)) {
                System.out.println("Invalid Chance");
                System.out.println("Enter valid position again");
                count--;
                box = in.nextInt();
            }
            display();
            user1pos.add(box);
        }

        else {
            Scanner in = new Scanner(System.in);
            box = in.nextInt();
            while(user1pos.contains(box) || user2pos.contains(box)) {
                System.out.println("Invalid Chance");
                System.out.println("Enter valid position again");
                count--;
                box = in.nextInt();
            }
            display();
            user2pos.add(box);
        }
    }

    // To check the win conditions and display winner
    private boolean alcheck() {
        if (rowcheck() || columncheck() || diagonalcheck1() || diagonalcheck2()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean rowcheck() {
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][2] == board[i][1] && board[i][1] != '\0') {
                System.out.println("Congrats.. " + p1.k + " win");
                return true;
            }
        }
        return false;
    }

    private boolean columncheck() {
        for (j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[2][j] == board[1][j] && board[1][j] != '\0') {
                System.out.println("Congrats.. " + p1.k + " win");
                return true;
            }
        }
        return false;
    }

    private boolean diagonalcheck1() {
        if (board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != '\0') {
            System.out.println("Congrats.. " + p1.k + " win");
            return true;
        }
        return false;
    }

    private boolean diagonalcheck2() {
        if (board[0][2] == board[1][1] && board[2][0] == board[1][1] && board[1][1] != '\0') {
            System.out.println("Congrats.. " + p1.k + " win");
            return true;
        }
        return false;
    }
}


