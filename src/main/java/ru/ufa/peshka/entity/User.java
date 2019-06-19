package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.StatusUser;

/*пользователь сайта*/
public class User extends Person{
    /*логин пользователя*/
    private String login;
    /*пароль пользователя*/
    private  String password;
    /*уровень доступа пользователя, роли (секретарь или просто пользователь)*/
    private StatusUser status;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User (){
        this.status = StatusUser.USER;
    }
    public StatusUser getStatus() {
        return status;
    }

    public void setStatus(StatusUser status) {
        this.status = status;
    }
}
