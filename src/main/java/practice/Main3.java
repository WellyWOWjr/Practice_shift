package practice;

public class Main3 {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object1) {
                System.out.println("Заблокирован монитор object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2) {
                    System.out.println("Thread 1");
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object2) {
                System.out.println("Заблокирован монитор object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1) {
                    System.out.println("Thread 2");
                }
            }
        }
    }
}
