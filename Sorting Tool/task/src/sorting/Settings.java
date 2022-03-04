package sorting;

import java.util.Arrays;

public class Settings {

    private final String[] args;
    public final DataType dataType;
    public final boolean isSorted;

    public Settings(String[] args) {
        this.args = args;
        this.isSorted = findIsSorted();
        this.dataType = findType();
    }

    private DataType findType() {
        if (findIsSorted()) {
            return DataType.LONG;
        }

        int dataTypeIndex = Arrays.asList(args).indexOf("-dataType");

        if (dataTypeIndex == -1) {
            return DataType.WORD;
        }

        return DataType.valueOf(args[dataTypeIndex + 1].toUpperCase());
    }

    private boolean findIsSorted() {
        int isSortedIndex = Arrays.asList(args).indexOf("-sortIntegers");

        return isSortedIndex > -1;
    }
}