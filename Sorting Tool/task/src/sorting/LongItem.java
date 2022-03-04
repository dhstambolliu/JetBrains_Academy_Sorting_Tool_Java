package sorting;

import java.util.Comparator;

public class LongItem implements Item {

    private final Long value;

    public LongItem(Long value) {
        this.value = value;
    }

    @Override
    public Comparator<Item> comparator() {
        return (item, otherItem) -> {
            LongItem one = (LongItem) item;
            LongItem other = (LongItem) otherItem;

            return one.value.compareTo(other.value);
        };
    }

    @Override
    public boolean equals(Item item) {
        return this.value.equals(((LongItem) item).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}