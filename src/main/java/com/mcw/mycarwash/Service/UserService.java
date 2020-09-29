package com.mcw.mycarwash.Service;



import com.mcw.mycarwash.Model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User get(String id);

    void saveUser(User user);

    void deleteUser(String id);

    User logingCheck(User user);


}
