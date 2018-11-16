package com.coreteka.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

    @Entity
    @Table(name = "t_user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username", unique = true)
        private String username;

        @Column(name = "password")
        private String password;

        @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
        private DriverProfile driverProfile;

        @Column (name = "user_status")
        private boolean userStatus;


        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_authorities",
                joinColumns = @JoinColumn(name = "user_id", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "auth_name")
        )
        @NotEmpty
        private Set<Authorities> authorities;

        public User() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public DriverProfile getDriverProfile() {
            return driverProfile;
        }

        public void setDriverProfile(DriverProfile driverProfile) {
            this.driverProfile = driverProfile;
        }

        public Set<Authorities> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(Set<Authorities> authorities) {
            this.authorities = authorities;
        }

        public boolean isUserStatus() {
            return userStatus;
        }

        public void setUserStatus(boolean userStatus) {
            this.userStatus = userStatus;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(id, user.id) &&
                    Objects.equals(username, user.username) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, password);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", driverProfile=" + driverProfile +
                    ", user_status=" + userStatus +
                    '}';
        }
    }

