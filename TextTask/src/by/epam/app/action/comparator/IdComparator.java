package by.epam.app.action.comparator;

import by.epam.app.entity.BaseTextItem;

import java.util.Comparator;

public class IdComparator implements Comparator<BaseTextItem> {
    @Override
    public int compare(BaseTextItem item1, BaseTextItem item2) {
        return Integer.compare(item1.getId(), item2.getId());
    }
}