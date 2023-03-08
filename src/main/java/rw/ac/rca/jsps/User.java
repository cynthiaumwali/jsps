package rw.ac.rca.jsps;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public User(String afname, String alname, String email, String apassword){
        this.setFname(afname);
        this.setLname(alname);
        this.setEmail(email);
        this.setPassword(apassword);
    }
    public User(String id, String afname, String alname, String email, String apassword){
        this.setId(id);
        this.setFname(afname);
        this.setLname(alname);
        this.setEmail(email);
        this.setPassword(apassword);

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String fname;
    private String lname;
    private String email;
    private String password;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
