package entities;

public class Book {
    private String name;
    private String author;
    private boolean available;
    public Integer Id;

    public Book(String name, String author, boolean available, Integer Id) {
        this.author = author;
        this.name = name;
        this.available = available;
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
    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                ", Id=" + Id +
                '}';
    }
}
