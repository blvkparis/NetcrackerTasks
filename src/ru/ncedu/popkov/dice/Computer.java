package ru.ncedu.popkov.dice;

/**
 * Represents Computer class
 *
 * @author Anton Popkov
 */
public class Computer {
    private int score;
    private int wins;

    /**
     * Constructor for computer
     */
    public Computer() {
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

    /**
     * Method for rolling the dice by Computer
     *
     * @param dice number of dice
     * @return score
     */
    public int rollDice(int dice) {
        for (int i = 0; i < dice; i++) {
            int random = (1 + (int) (Math.random() * 6));
            score += random;
            System.out.println("Throw " + i + " - " + random);
        }

        System.out.println("Final score - " + score);
        setScore(score);
        return score;
    }
}
