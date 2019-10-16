package by.epam.entity;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Van implements Runnable, Comparable<Van> {

    private Goods goods;
    private boolean toLoad;
    private Thread thread;

    public Van(boolean toLoad) {
        this.toLoad = toLoad;
        goods = null;
        thread = new Thread(this);
    }

    public Van(Goods goods, boolean toLoad) {
        this.toLoad = toLoad;
        this.goods = goods;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        LogisticBase.getInstance().request(this);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void load(Goods goods) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.goods = goods;
    }

    public Goods unload() {
        if (goods != null) {
            System.out.println(goods.getName());
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Goods temp = goods;
        goods = null;
        return temp;
    }

    public boolean toLoad() {
        return toLoad;
    }

    public String getGoodsName() {
        if (goods != null) {
            return goods.getName();
        } else {
            return "Nothing";
        }
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