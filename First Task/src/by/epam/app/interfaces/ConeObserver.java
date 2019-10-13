package by.epam.app.interfaces;


import by.epam.app.entity.ConeEvent;

public interface ConeObserver {
    void update(ConeEvent event);
}
