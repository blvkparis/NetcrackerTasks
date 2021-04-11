package ru.ncedu.popkov.dice;

import java.util.Scanner;

public class Player {
    private int score;
    private int wins;
    private int playerIndex;

    public Player() {
        score = 0;
        wins = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int rollDice(int dice) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < dice; i++) {
            System.out.print("Roll the Dice (Press Enter)");
            scanner.nextLine();

            int random = (1 + (int) (Math.random() * 6));
            score += random;
            System.out.println("Throw " + i + " - " + random);
        }

        System.out.println("Final score - " + score);
        setScore(score);
        return score;
    }

    @Override
    public String toString() {
        return "Player " + playerIndex;
    }
}
