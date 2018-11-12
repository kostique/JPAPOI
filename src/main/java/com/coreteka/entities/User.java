package com.coreteka.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

    @Entity
    @Table(name = "t_user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username")
        private String username;

        @Column(name = "password")
        private String password;


        @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private DriverProfile driverProfile;

        @Column (name = "user_status")
        private boolean user_status;


        @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
        @JoinTable(
                name = "user_authorities",
                joinColumns = @JoinColumn(name = "user_id", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "auth_name", nullable = false)
        )
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

        public boolean isUser_status() {
            return user_status;
        }

        public void setUser_status(boolean user_status) {
            this.user_status = user_status;
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
            return Objects.hash(id, username, password);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", driverProfile=" + driverProfile +
                    ", user_status=" + user_status +
                    '}';
        }
    }

