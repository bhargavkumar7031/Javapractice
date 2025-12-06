package org.example.DTO;


public class AuthRequest {
    private String userName;
    private String password;

    public AuthRequest() {}

    public AuthRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
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
        return "AuthRequest{" +
                "Username='" + userName + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}