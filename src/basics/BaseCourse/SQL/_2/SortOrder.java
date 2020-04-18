package basics.BaseCourse.SQL._2;

public enum SortOrder {
    ORDER_BY_NONE(""),
    ORDER_BY_ASC("ASC"),
    ORDER_BY_DESC("DESC");

    public final String value;
    SortOrder(String value) {
        this.value = value;
    }
}
