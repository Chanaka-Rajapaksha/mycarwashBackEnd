package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.UserDao;
import com.mcw.mycarwash.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public void saveUser(User client) {

    }

    @Override
    public void deleteUser(String id) {

    }
}
