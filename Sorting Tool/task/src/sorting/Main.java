package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) {
        Settings settings = new Settings(args);

        SortingTool tool;
        switch (settings.dataType) {
            case LONG:
                tool = handleLongs(settings);
                break;
            case LINE:
                tool = handleLines();
                break;
            default:
                tool = handleWords();
                break;
        }

        int total = tool.total();
        Item greatest = tool.greatest();
        int frequency = tool.frequency(greatest);
        int ratio = (frequency * 100) / total ;
        List<Item> sorted = tool.sort();

        switch (settings.dataType) {
            case LONG:
                System.out.println("Total numbers: " + total + ".");
                if (settings.isSorted) {
                    String sortedData = sorted.stream().map(Item::toString).collect(Collectors.joining(" "));
                    System.out.println("Sorted data: " + sortedData);
                } else {
                    System.out.println("The greatest number: " + greatest + " (" + frequency + " time(s), " + ratio + "%).");
                }
                break;
            case LINE:
                System.out.println("Total lines: " + total + ".");
                System.out.println("The longest line:\n" + greatest + "\n(" + frequency + " time(s), " + ratio + "%).");
                break;
            default:
                System.out.println("Total words: " + total + ".");
                System.out.println("The longest word: " + greatest + " (" + frequency + " time(s), " + ratio + "%).");
                break;
        }
    }

    public static SortingTool handleLines() {
        Scanner scanner = new Scanner(System.in);

        SortingTool tool = new SortingTool(DataType.LINE);

        while (scanner.hasNextLine()) {
            tool.addItem(new StringItem(scanner.nextLine()));
        }

        return tool;
    }

    public static SortingTool handleWords() {
        Scanner scanner = new Scanner(System.in);

        SortingTool tool = new SortingTool(DataType.WORD);

        while (scanner.hasNext()) {
            tool.addItem(new StringItem(scanner.next()));
        }

        return tool;
    }

    public static SortingTool handleLongs(Settings settings) {
        Scanner scanner = new Scanner(System.in);

        SortingTool tool = new SortingTool(DataType.LONG);

        while (scanner.hasNextLong()) {
            tool.addItem(new LongItem(scanner.nextLong()));
        }

        return tool;
    }

    public static DataType parseType(String[] args) {
        if (args.length >= 2) {
            return DataType.valueOf(args[1].toUpperCase());
        }
        return DataType.WORD;
    }
}