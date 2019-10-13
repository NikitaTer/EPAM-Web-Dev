package by.epam.app.entity;

import java.util.Comparator;
import java.util.ListIterator;

public interface BaseTextItem {

    boolean add(BaseTextItem child);
    boolean remove(BaseTextItem child);
    int countAllItems();
    int countItems();
    void sort(Comparator<BaseTextItem> comparator);
    void restore();
    ListIterator<BaseTextItem> createListIterator();

    //BaseTextItem getParent();
    //void setParent(BaseTextItem parent);

    int getId();
}