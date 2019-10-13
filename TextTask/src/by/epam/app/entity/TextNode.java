package by.epam.app.entity;

import by.epam.app.action.IdGiver;
import by.epam.app.action.comparator.IdComparator;

import java.util.*;

public class TextNode implements BaseTextItem {

    private LinkedList<BaseTextItem> children;
    private int id;
    private ElementType type;

    public TextNode(ElementType type) {
        children = new LinkedList<>();
        id = IdGiver.getID();
        this.type = type;
    }

    @Override
    public boolean add(BaseTextItem child) {
        return children.add(child);
    }

    @Override
    public boolean remove(BaseTextItem child) {
        ListIterator listIterator = createListIterator();
        BaseTextItem temp;

        while (listIterator.hasNext()) {
            temp = (BaseTextItem) listIterator.next();
            if (temp == child) {
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public int countAllItems() {
        int totalCount = 0;
        ListIterator iterator = createListIterator();
        BaseTextItem temp;

        while (iterator.hasNext()) {
            temp = (BaseTextItem) iterator.next();
            totalCount += temp.countAllItems();
        }

        return totalCount;
    }

    @Override
    public int countItems() {
        return children.size();
    }

    @Override
    public void sort(Comparator<BaseTextItem> comparator) {
        children.sort(comparator);
    }

    @Override
    public void restore() {
        children.sort(new IdComparator());

        ListIterator iterator = createListIterator();

        while (iterator.hasNext()) {
            BaseTextItem temp = (BaseTextItem) iterator.next();
            temp.restore();
        }
    }

    @Override
    public ListIterator<BaseTextItem> createListIterator() {
        return children.listIterator();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)  {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TextNode textNode = (TextNode) o;

        return children.equals(textNode.children) && type.equals(textNode.type);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * children.hashCode();
        result += 31 * type.hashCode();

        return result;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();;

        for (BaseTextItem b : children) {
            temp.append(b.toString());
        }

        if (type == ElementType.NEW_LINE) {
            return temp.toString() + "\n";
        } else {
            return temp.toString();
        }
    }
}