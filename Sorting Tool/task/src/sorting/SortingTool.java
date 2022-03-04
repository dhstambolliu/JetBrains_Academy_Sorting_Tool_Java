package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortingTool {
    public final DataType dataType;
    private ArrayList<Item> items = new ArrayList<>();

    public SortingTool(DataType type) {
        dataType = type;
    }

    public void addItem(Item item)  {
        items.add(item);
    }

    public int total() {
        return items.size();
    }

    public Item greatest() {
        return items.stream()
                // @TODO maybe find a more elegant way
                .max(items.get(0).comparator())
                .orElse(null);
    }

    public int frequency(Item item) {
        int frequency = 0;

        for (Item anItem : items) {
            if (anItem.equals(item)) {
                frequency++;
            }
        }

        return frequency;
    }

    public List<Item> sort() {
        return items.stream()
                // @TODO maybe find a more elegant way
                .sorted(items.get(0).comparator())
                .collect(Collectors.toList());
    }
}