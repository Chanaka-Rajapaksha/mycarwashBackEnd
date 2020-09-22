package com.mcw.mycarwash.Service;



import com.mcw.mycarwash.Model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User get(String id);

    void saveUser(User client);

    void deleteUser(String id);


}
