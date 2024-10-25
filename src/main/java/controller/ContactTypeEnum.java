package controller;

public enum ContactTypeEnum {
    PERSON("person"),
    ORGANIZATION("organization");

    private final String type;

    ContactTypeEnum(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return type;
    }
}
