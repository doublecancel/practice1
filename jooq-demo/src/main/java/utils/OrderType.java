package utils;

public enum OrderType {
    ASC("asc"), DESC("desc");

    private String name;

    OrderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
