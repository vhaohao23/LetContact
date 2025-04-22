package application.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "UserID", length = 200)
    private String userID;

    @Column(name = "UserName", length = 50, nullable = false)
    private String userName;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "Dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "Gender", length = 50)
    private String gender;

    @Column(name = "Address", length = 200)
    private String address;

    @Column(name = "Phone", length = 50)
    private String phone;

    @Column(name = "Email", length = 200, nullable = false)
    private String email;

    @Column(name = "Password", length = 50, nullable = false)
    private String password;

    @Column(name = "Status", length = 50, nullable = false)
    private String status="NOTACTIVE";

    @Lob
    @Column(name = "Avatar",columnDefinition = "LONGBLOB")
    private byte[] avatar;

    public User() {
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
