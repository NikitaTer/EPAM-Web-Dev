package by.epam.entity;

import by.epam.action.PrioritySemaphore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase {
    private static final LogisticBase instance = new LogisticBase();
    private static final Logger logger = LogManager.getLogger();

    private static final int CAPACITY = 500;
    private static Queue<Goods> goods;
    private PrioritySemaphore semLoad;
    private PrioritySemaphore semUnload;
    private Lock goodsLock;
    private Condition isFull;
    private Condition isEmpty;

    private LogisticBase() {
        goods = new PriorityQueue<>();
        semLoad = new PrioritySemaphore(2);
        semUnload = new PrioritySemaphore(2);
        goodsLock = new ReentrantLock(true);
        isFull = goodsLock.newCondition();
        isEmpty = goodsLock.newCondition();
    }

    public static LogisticBase getInstance() {
        return instance;
    }

    public void request(Van van) {
        logger.info("Handling request from " + van.getGoodsName());

        if (van.toLoad()) {
            semLoad.acquire(van);

            try {

                goodsLock.lock();
                while (goods.size() == 0) {
                    logger.info("Storage is empty");
                    isEmpty.await();
                }
                Goods temp = goods.remove();
                isFull.signal();
                goodsLock.unlock();
                van.load(temp);

            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }

            semLoad.release();
        } else {
            semUnload.acquire(van);

            try {

                goodsLock.lock();
                while (goods.size() == CAPACITY) {
                    logger.info("Storage is full");
                    isFull.await();
                }
                goodsLock.unlock();

                Goods temp = van.unload();

                goodsLock.lock();
                goods.add(temp);
                isEmpty.signal();
                goodsLock.unlock();

            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }

            semUnload.release();
        }

        logger.info("Ending handling request from " + van.getGoodsName());
    }
}