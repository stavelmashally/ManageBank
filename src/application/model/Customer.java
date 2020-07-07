package application.model;
import java.util.Date;

public class Customer extends User {

    private String address;
    private String city;
    private Date birthDate;
    private String phone;

    public Customer(int id, String fName, String lName, String email, String phone, String address, String city) {
        super(id, fName, lName, email);
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public Customer(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
