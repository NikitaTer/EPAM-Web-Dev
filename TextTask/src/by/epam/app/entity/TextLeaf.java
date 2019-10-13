package by.epam.app.entity;

import by.epam.app.action.IdGiver;

import java.util.Comparator;
import java.util.ListIterator;

public class TextLeaf implements BaseTextItem {

    private String element;
    private ElementType type;

    private int id;

    public TextLeaf(String element, ElementType type) {
        this.element = element;
        this.id = IdGiver.getID();
        this.type = type;
    }

    @Override
    public boolean add(BaseTextItem child) {
        return false;
    }

    @Override
    public boolean remove(BaseTextItem child) {
        return false;
    }

    @Override
    public int countAllItems() {
        return countItems();
    }

    @Override
    public int countItems() {
        return element.length();
    }

    @Override
    public void sort(Comparator<BaseTextItem> comparator) {

    }

    @Override
    public void restore() {

    }

    @Override
    public ListIterator<BaseTextItem> createListIterator() {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TextLeaf textLeaf = (TextLeaf) o;

        return  element.equals(textLeaf.element) && type.equals(textLeaf.type);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * element.hashCode();
        result += 31 * type.hashCode();

        return result;
    }

    @Override
    public String toString() {
        switch (type) {
            case SPACE:
                return element + " ";

            case NON:
                return element;

            default:
                return "";
        }
    }
}