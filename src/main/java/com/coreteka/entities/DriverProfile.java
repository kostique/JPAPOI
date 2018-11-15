package com.coreteka.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "t_driver_profile")
public class DriverProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)  //cascade = CascadeType.ALL,
    @JoinColumn(name = "user_id", unique = true, nullable = false) //
    private User user;


    public DriverProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverProfile that = (DriverProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(user, that.user);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phone);
    }


    @Override
    public String toString() {
        return "DriverProfile{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
