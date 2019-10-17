package by.epam.action;

import by.epam.entity.Van;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrioritySemaphore {

    private final static Logger logger = LogManager.getLogger();

    private Semaphore semaphore;
    private PriorityQueue<Van> queue;
    private Lock queueLock;
    private Lock waitLock;
    private Condition waiting;

    public PrioritySemaphore(int permits) {
        semaphore = new Semaphore(permits, true);
        queue = new PriorityQueue<>();
        queueLock = new ReentrantLock(true);
        waitLock = new ReentrantLock(true);
        waiting = waitLock.newCondition();
    }

    public void acquire(Van van) {
        queueLock.lock();
        queue.add(van);
        queueLock.unlock();

        try {
            logger.info(van.getGoodsName() + " is waiting");

            while (queue.peek() != van || semaphore.hasQueuedThreads()) {
                waitLock.lock();
                waiting.await();
                waitLock.unlock();
            }
            queueLock.lock();

            queue.remove();
            semaphore.acquire();

            waitLock.lock();
            waiting.signalAll();
            waitLock.unlock();

            queueLock.unlock();

            logger.info(van.getGoodsName() + " is stop waiting");

        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    public void release() {
        semaphore.release();
        waitLock.lock();
        waiting.signalAll();
        waitLock.unlock();
    }
}