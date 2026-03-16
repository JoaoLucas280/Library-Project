package entities;

public class Book {
    private String name;
    private String author;
    private boolean available;
    private Integer Id;

    public Book() {}

    public Book(String name, String author, Integer Id) {
        this.author = author;
        this.name = name;
        this.Id = Id;
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

    @Override
    public String toString() {
        return "name:'" + name + '\'' +
                ", author:'" + author + '\'' +
                ", Id:" + Id +
                ", available:" + available;
    }
}
