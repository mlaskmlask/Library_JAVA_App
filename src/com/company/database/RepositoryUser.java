package com.company.database;

import com.company.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class RepositoryUser {

    public static final RepositoryUser repositoryUser = new RepositoryUser();
    List<User> userList = new ArrayList<>();

    public RepositoryUser() {
        userList.add(new User("Kasia", "Kowalska", User.Role.ADMIN, "kasia", DigestUtils.md5Hex("kasia")));
        userList.add(new User("Tomek", "Kowal", User.Role.USER, "tomek", DigestUtils.md5Hex("tomek")));
    }

    public static RepositoryUser getInstance() {
        return repositoryUser;
    }

    public User findUser(String login) {
        for (User currentUser : this.userList) {
            if (currentUser.getLogin().equals(login)) {
                return currentUser;
            }
        }
        return null;
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public boolean login(String login, String pass) {
        for (User currentUser : this.userList) {
            if (currentUser.getLogin().equals(login)) {
                if (currentUser.getPassword().equals(DigestUtils.md5Hex(pass))) {
                    return true;
                }
            }
        }
        return false;
    }

}
