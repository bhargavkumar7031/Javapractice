package org.example.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Auth {

    @Id
    private String userName;
    private String password;

    public Auth() {}

    public Auth(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Auth(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private String userName;
        private String password;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder Password(String password){
            this.password = password;
            return this;
        }

        public Auth build() {
            return new Auth(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
