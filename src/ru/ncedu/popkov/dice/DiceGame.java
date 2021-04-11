package ru.ncedu.popkov.dice;

public class DiceGame {
    private int N;
    private int K;
    private Player[] players;
    private int rounds;
    private Computer computer;

    public DiceGame(int n, int k) {
        N = n;
        K = k;
        computer = new Computer();
        players = new Player[N];
        rounds = 1;
    }

    private void setPlayers() {
        for (int i = 0; i < N; i++) {
            players[i] = new Player();
            players[i].setPlayerIndex(i);
        }
    }

    public void playGame() {
        setPlayers();
        while (rounds <= 7) {
            System.out.println("Round " + rounds + " started!");
            for (int i = 0; i < N; i++) {
                System.out.println(players[i] + " rolls the dice");
                players[i].rollDice(K);
                System.out.println("\n");
            }

            System.out.println("Computer rolls the dice");
            computer.rollDice(K);
            getMaxScore();

            //Reset the players score
            for (int i = 0; i < N; i++) {
                players[i].setScore(0);
            }
            computer.setScore(0);

            rounds++;
        }
        Player winner = getWinner();
        System.out.println("Game over! " + winner + " has won the game with " + winner.getWins() + " wins!");
    }

    private void getMaxScore() {
        int maxScore = -1;
        int index = 0;

        for (int i = 0; i < N; i++) {
            if (players[i].getScore() > maxScore) {
                maxScore = players[i].getScore();
                index = i;
            }
        }

        if (maxScore < computer.getScore()) {
            System.out.println("Computer won the round with the score " + computer.getScore());
            computer.setWins(computer.getWins() + 1);
        } else {
            System.out.println(players[index] + " won the round with the score "
                    + players[index].getScore());

            players[index].setWins(players[index].getWins() + 1);
        }

        //Putting the winner in first Place
        Player temp = players[index];
        players[index] = players[0];
        players[0] = temp;
    }

    public Player getWinner() {
        Player player = players[0];
        int wins = 0;

        for (int i = 0; i < N; i++) {
            if (players[i].getWins() > wins)
                player = players[i];
        }

        return player;
    }
}