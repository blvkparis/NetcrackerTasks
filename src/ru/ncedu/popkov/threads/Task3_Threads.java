package ru.ncedu.popkov.threads;

/**
 * @author Anton Popkov
 */
public class Task3_Threads {
    private int i = 0;

    /**
     * Method that increment i
     *
     * @return int
     */
    public synchronized int increment() {
        while (i <= 100) {
            System.out.println("Variable i equals " + i);
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Task3_Threads main = new Task3_Threads();
        Thread thread1 = new Thread(String.valueOf(main.increment()));
        thread1.start();
        Thread thread2 = new Thread(String.valueOf(main.increment()));
        thread2.start();
    }
}