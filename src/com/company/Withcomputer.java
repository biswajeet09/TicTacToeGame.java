package com.company;
// code to play with computer

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Withcomputer {
    private String user,k,turn;
    private char sym;
    private int box, i, j;
    private char[][] board = new char[3][3];
    private ArrayList userpos = new ArrayList();
    private ArrayList compos = new ArrayList();


    public void game(){
        player();
        int count=1;
        while (count <= 10) {
            if (count == 10) {
                System.out.println("The game Draw");
                break;
            }
            System.out.println("Game is on");
            whoseturn();
            move();
            if (alcheck()) {
                break;
            }
            count++;
        }
    }

    private void player() {
        System.out.println("Enter your name");
        Scanner scan = new Scanner(System.in);
        user = scan.nextLine();
        turn = user;
    }


    private void move() {
        if(k.equals(user)){
            Scanner s = new Scanner(System.in);
            box = s.nextInt();
            while(userpos.contains(box) || compos.contains(box)){
                System.out.println("Invalid Chance");
                System.out.println("Enter valid position again");
                box = s.nextInt();
            }
            display();
            userpos.add(box);
        }
        else{
            Random rand = new Random();
            box = rand.nextInt(9) + 1;
            System.out.println(box);
            while(userpos.contains(box) || compos.contains(box)) {
                System.out.println("Invalid Chance");
                System.out.println("Enter valid position again");
                box = rand.nextInt(9) + 1;
                System.out.println(box);
            }
            display();
            compos.add(box);
        }
    }


    private String whoseturn() {
        if (turn == user) {
            sym='X';
            System.out.println(user + " turn");
            turn= "Computer";
            k=user;
        }
        else {
            System.out.println("Computer turn");
            sym='O';
            turn= user;
            k= "Computer";
        }
        return  k;
    }

    private void display() {
        if (box == 9)
            board[2][2] = sym;
        if (box == 8)
            board[2][1] = sym;
        if (box == 7)
            board[2][0] = sym;
        if (box == 6)
            board[1][2] = sym;
        if (box == 5)
            board[1][1] = sym;
        if (box == 4)
            board[1][0] = sym;
        if (box == 3)
            board[0][2] = sym;
        if (box == 2)
            board[0][1] = sym;
        if (box == 1)
            board[0][0] = sym;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board.length; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

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
                System.out.println("Congrats.." + k + " win");
                return true;
            }
        }
        return false;
    }

    private boolean columncheck() {
        for (j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[2][j] == board[1][j] && board[1][j] != '\0') {
                System.out.println("Congrats.." + k + " win");
                return true;
            }
        }
        return false;
    }

    private boolean diagonalcheck1() {
        if (board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != '\0') {
            System.out.println("Congrats.." + k + " win");
            return true;
        }
        return false;
    }

    private boolean diagonalcheck2() {
        if (board[0][2] == board[1][1] && board[2][0] == board[1][1] && board[1][1] != '\0') {
            System.out.println("Congrats.." + k + " win");
            return true;
        }
        return false;
    }
}

