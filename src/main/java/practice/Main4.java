package practice;

import java.util.concurrent.ThreadLocalRandom;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        LikeQueue queue = new LikeQueue();

        for (int i = 1; i <= 10; i++) {
            int k = i;
            Thread t1 = new Thread(() -> {
                int goodNight = ThreadLocalRandom.current().nextInt(1, 10);
                try {
                    Thread.sleep(goodNight * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.add("Element " + k);
                System.out.println(Thread.currentThread());
            });
            t1.start();
        }


        for (int i = 1; i <= 10; i++) {
            System.out.println(queue.peek());
        }
    }
}
