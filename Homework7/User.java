package HillelHomeworks.Homework7;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    UserEnum type;

    public User(String login, String password, UserEnum type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && type == user.type;
    }

    @Override
    public int hashCode() {
        return this.login.hashCode() + 11 * this.password.hashCode() + this.type.priority;
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

}
