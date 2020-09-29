package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.UserDao;
import com.mcw.mycarwash.Model.User;
import com.mcw.mycarwash.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Transactional
    @Override
    public User get(String id) {
        return userDao.get(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public User logingCheck(User user) {

        return  userDao.logingCheck(user);
    }
}
