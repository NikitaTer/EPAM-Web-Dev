package by.epam.app.interfaces;

public interface ConeObservable {
    void addObserver(ConeObserver observer);
    void removeObserver(ConeObserver observer);
    void notifyObservers();
    void notifyObserver(ConeObserver observer);
}
