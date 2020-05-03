package application.model;

public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String email;

    public User(int id, String FirstName, String LastName, String email) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}