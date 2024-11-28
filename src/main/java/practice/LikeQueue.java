package practice;

import java.util.ArrayList;
import java.util.List;

public class LikeQueue {
    private final List<String> queue = new ArrayList<>();

    public synchronized void add(String s) {
        queue.add(s);
        notifyAll();
    }

    public synchronized String peek() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }
        return queue.remove(0);
    }
}

