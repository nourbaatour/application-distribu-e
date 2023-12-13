import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Client implements Serializable {
    private static  final long serialVersionUID=6;

    @jakarta.persistence.Id
    @GeneratedValue
    public long Id;

    public String name;
    public String surname;
    public String sex;
    public String location;
    public String email;
    public String entreprise;
    public Date dob;
    public String tel;
    public String postcard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostcard() {
        return postcard;
    }

    public void setPostcard(String postcard) {
        this.postcard = postcard;
    }

    public Client() {
        super();
    }

    public Client(String name) {
        super();
        this.name = name;
    }
}
