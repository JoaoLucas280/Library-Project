package entities;

public class Book {
    private String name;
    private String author;
    private boolean available;
    private Integer Id;

    public Book() {}

    public Book(String name, String author) {
        this.author = author;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "name:'" + name + '\'' +
                ", author:'" + author + '\'' +
                ", Id:" + Id +
                ", available:" + available;
    }
}
