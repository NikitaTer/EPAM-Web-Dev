package by.epam.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Van implements Runnable, Comparable<Van> {

    private static final Logger logger = LogManager.getLogger();

    private Goods goods;
    private boolean toLoad;
    private Thread thread;

    public Van(boolean toLoad) {
        this.toLoad = toLoad;
        goods = new Goods("Nothing", 0, false);
        thread = new Thread(this);
    }

    public Van( boolean toLoad, Goods goods) {
        this.toLoad = toLoad;
        this.goods = goods;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        LogisticBase.getInstance().request(this);
    }

    public void start() {
        logger.info("Starting thread");
        thread.start();
    }

    public void stop() {
        try {
            logger.info("Stopping thread");
            thread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    public void load(Goods goods) {
        logger.info("Loading " + goods.getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

        this.goods = goods;
    }

    public Goods unload() {
        logger.info("Unloading " + goods.getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

        Goods temp = goods;
        goods = new Goods("Nothing", 0, false);
        return temp;
    }

    public boolean toLoad() {
        return toLoad;
    }

    public String getGoodsName() {
        return goods.getName();
    }

    public int getGoodsWeight() {
        if (goods != null) {
            return goods.getWeight();
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Van van) {
        return Integer.compare(van.goods.getPriority(), goods.getPriority());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Van van = (Van) o;
        return  toLoad == van.toLoad &&
                goods.equals(van.goods);
    }

    @Override
    public int hashCode() {
        int result = 17;

        if (toLoad) {
            result += 31;
        }
        result += 31 * goods.hashCode();

        return result;
    }
}