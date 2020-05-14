package models;

public class Category {

    private String name, metaTagTitle, description;
    private boolean top = false;

    public Category(String name, String metaTagTitle, String description, boolean top) {
        this.name = name;
        this.metaTagTitle = metaTagTitle;
        this.description = description;
        this.top = top;
    }

    public String getName() {
        return name;
    }

    public String getMetaTagTitle() {
        return metaTagTitle;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTop() {
        return top;
    }
}
