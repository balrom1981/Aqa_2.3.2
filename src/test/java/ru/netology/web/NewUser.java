package ru.netology.web;


import lombok.Data;

@Data
public class NewUser {
    private String login;
    private String password;
    private String status;

    public NewUser() {

    }

    public NewUser(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}