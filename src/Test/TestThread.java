package Test;

public class TestThread {
    public static int i = 0;

    public static final int TOTAL = 100;

    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (i <= TOTAL) {
                synchronized (lock) {
                    if (i % 2 == 1) {
                        System.out.println("奇数i=" + i++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (i <= TOTAL) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println("偶数i=" + i++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}