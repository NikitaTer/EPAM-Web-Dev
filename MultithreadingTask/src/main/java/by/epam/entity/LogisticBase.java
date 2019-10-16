package by.epam.entity;

import by.epam.action.PrioritySemaphore;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase {
    private static final LogisticBase instance = new LogisticBase();

    private static final int CAPACITY = 500;
    private static Queue<Goods> goods;
    private PrioritySemaphore semLoad;
    private PrioritySemaphore semUnload;
    private Lock lock;

    private LogisticBase() {
        goods = new PriorityQueue<>();
        semLoad = new PrioritySemaphore(1);
        semUnload = new PrioritySemaphore(1);
        lock = new ReentrantLock(true);
    }

    public static LogisticBase getInstance() {
        return instance;
    }

    public void request(Van van) {
        if (van.toLoad()) {
            semLoad.acquire(van);

            while (true) {
                lock.lock();
                if (goods.size() > 0) {
                    Goods temp = goods.remove();
                    lock.unlock();
                    van.load(temp);
                    break;
                }

                lock.unlock();
            }

            semLoad.release();
        } else {
            semUnload.acquire(van);

            while (true) {
                lock.lock();
                if (goods.size() < CAPACITY) {
                    lock.unlock();

                    Goods temp = van.unload();

                    lock.lock();
                    goods.add(temp);
                    lock.unlock();
                    break;
                }

                lock.unlock();
            }

            semUnload.release();
        }
    }
}