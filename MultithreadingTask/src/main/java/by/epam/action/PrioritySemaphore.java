package by.epam.action;

import by.epam.entity.Van;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrioritySemaphore {

    private Semaphore semaphore;
    private PriorityQueue<Van> queue;
    private Lock lock;

    public PrioritySemaphore(int permits) {
        semaphore = new Semaphore(permits, true);
        queue = new PriorityQueue<>();
        lock = new ReentrantLock(true);
    }

    public void acquire(Van van) {
        lock.lock();
        queue.add(van);
        lock.unlock();

        try {
            while (true) {
                lock.lock();
                if (van.equals(queue.peek()) && !semaphore.hasQueuedThreads()) {
                    queue.remove();
                    semaphore.acquire();
                    lock.unlock();
                    break;
                }
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        semaphore.release();
    }
}