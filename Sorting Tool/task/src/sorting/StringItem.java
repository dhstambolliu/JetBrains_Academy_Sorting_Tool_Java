package sorting;


import java.util.Comparator;

public class StringItem implements Item {

    private final String value;

    public StringItem(String value) {
        this.value = value;
    }

    @Override
    public Comparator<Item> comparator() {
        return (item, otherItem) -> {
            StringItem one = (StringItem) item;
            StringItem other = (StringItem) otherItem;

            if (one.value.length() > other.value.length()) {
                return 1;
            }

            if (one.value.length() < other.value.length()) {
                return -1;
            }

            return one.value.compareTo(other.value);
        };
    }

    @Override
    public boolean equals(Item item) {
        return this.value.equals(((StringItem) item).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}