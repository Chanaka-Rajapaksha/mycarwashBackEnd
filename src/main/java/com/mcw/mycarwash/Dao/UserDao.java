package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User get(String id);

    void saveUser(User client);

    void deleteUser(String id);
}
