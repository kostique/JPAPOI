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
    private String full_name;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;


    public DriverProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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
                Objects.equals(full_name, that.full_name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(user, that.user);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, full_name, phone);
    }


    @Override
    public String toString() {
        return "DriverProfile{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
