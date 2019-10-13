package by.epam.app.entity;

import by.epam.app.action.Calculator;
import by.epam.app.interfaces.ConeObservable;
import by.epam.app.interfaces.ConeObserver;

import java.util.LinkedList;

public class Cone implements ConeObservable {

    private Point point;
    private double high;
    private double radius;

    private int id;

    private LinkedList<ConeObserver> observers;


    public Cone() {
        point = new Point();
        high = 0;
        radius = 0;
        observers = new LinkedList<>();
        id = Calculator.calculateId();
    }

    public Cone(Point point, double high, double radius) {
        this.point = point;
        this.high = high;
        this.radius = radius;
        observers = new LinkedList<>();
        id = Calculator.calculateId();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        notifyObservers();
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "point=" + point +
                ", high=" + high +
                ", radius=" + radius +
                ", id=" + id +
                ", observers=" + observers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cone cone = (Cone) o;

        return Double.compare(cone.high, high) == 0 &&
                Double.compare(cone.radius, radius) == 0 &&
                point.equals(cone.point);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * point.hashCode();
        result += 31 * Double.hashCode(radius);
        result += 31 * Double.hashCode(high);

        return result;
    }

    @Override
    public void addObserver(ConeObserver observer) {
        observers.add(observer);
        observer.update(new ConeEvent(this));
    }

    @Override
    public void removeObserver(ConeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ConeObserver observer : observers) {
            observer.update(new ConeEvent(this));
        }
    }

    @Override
    public void notifyObserver(ConeObserver observer) {
        observer.update(new ConeEvent(this));
    }
}