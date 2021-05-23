package ru.ncedu.popkov.threads;

/**
 * @author Anton Popkov
 */
public class Counter {
    private int count = 0;

    // Set the limit when count is off
    private int limit = 7;
    private boolean occupiedFlag = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Method that read count value
     *
     * @return count
     * @throws InterruptedException
     */
    public synchronized int readCountValue() throws InterruptedException {
        while (!occupiedFlag)
            wait();
        occupiedFlag = false;
        notify();
        return count;
    }

    /**
     * Method that write value to the count variable
     *
     * @param n int
     * @throws InterruptedException
     */
    public synchronized void writeCountValue(int n) throws InterruptedException {
        while (occupiedFlag)
            wait();
        count = n;
        occupiedFlag = true;
        notify();
    }

    /**
     * Method that runs Thread A
     *
     * @throws InterruptedException
     */
    public void runA() throws InterruptedException {
        while (count != limit) {
            Thread.sleep(1000);
            count = readCountValue();
            System.out.println(Thread.currentThread().getName() + " is working, count equals " + count);
        }
    }

    /**
     * Method that runs Thread B
     *
     * @throws InterruptedException
     */
    public void runB() throws InterruptedException {
        while (count != limit + 1) {
            Thread.sleep(1000);
            count++;
            writeCountValue(count);
            System.out.println(Thread.currentThread().getName() + " read count - " + count);
            if (count == limit + 1)
                System.out.println("Count is over a " + limit + " Thread-A is stopped");
        }
    }

    /**
     * Method that starts Thread A
     */
    public void startingAThread() {
        Thread threadA = new Thread(() -> {
            try {
                runA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-A");
        threadA.start();
    }

    /**
     * Method that starts Thread B
     */
    public void startingBThread() {
        Thread threadB = new Thread(() -> {
            try {
                runB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-B");
        threadB.start();
    }

    // Main method
    public static void main(String[] args) {
        Counter threads = new Counter();
        threads.startingAThread();
        threads.startingBThread();
    }
}