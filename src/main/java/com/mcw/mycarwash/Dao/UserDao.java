package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User get(String id);

    void saveUser(User user);

    void deleteUser(String id);

    User logingCheck(User user);
}
