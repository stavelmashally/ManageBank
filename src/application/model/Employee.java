package application.model;

public class Employee extends User {
    private String password;
    private String role;
    private String privileges;

    public Employee(int id, String fName, String lName, String email, String password, String role, String privileges) {
        super(id, fName, lName, email);
        this.password = password;
        this.role = role;
        this.privileges = privileges;
    }

    public Employee() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}
