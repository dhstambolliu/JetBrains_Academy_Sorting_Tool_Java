package sorting;

public enum DataType {
    LONG("long"),
    LINE("line"),
    WORD("word");

    private String type;

    DataType(String type) {
        this.type = type;
    }
}