package entities;

public class User {
    private Integer Id;
    private String name;
    private String email;

    public  User(Integer id, String name, String email) {
        this.Id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
