package ru.ncedu.popkov.dice;

import java.util.Scanner;

public class DiceGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of dice: ");
        int k = scanner.nextInt();

        DiceGame diceGame = new DiceGame(n, k);
        diceGame.playGame();
    }
}
