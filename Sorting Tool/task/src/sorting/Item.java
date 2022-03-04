package sorting;

import java.util.Comparator;

public interface Item {
    Comparator<Item> comparator();

    boolean equals(Item item);
}