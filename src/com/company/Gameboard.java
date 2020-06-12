package com.company;

//To show the Board diagram and instruction to play
public class Gameboard {
    private int i,j,k=1;
    public void show() {
        System.out.println("Instruction to Play-\tEnter the position number(0 to 9) where you want to place your turn");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print("| " + k + " |");
                k++;
            }
            System.out.println();
        }
        System.out.println();
    }
}


