package dto;

import java.util.UUID;

public class Books {
    private UUID id;
    private String name;
    private String categoryName;
    private String author;

    public Books() {
    }

    public Books(UUID id, String name, String categoryName, String author) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", name='" + name + '\'' + ", categoryName='" + categoryName + '\'' + ", author='" + author + '\'' + '}';
    }
}

