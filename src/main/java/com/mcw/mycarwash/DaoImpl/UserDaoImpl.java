package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.UserDao;
import com.mcw.mycarwash.Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery("FROM User", User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public User get(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class,id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(user);
    }

    @Override
    public void deleteUser(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class,id);
        currentSession.delete(id);
    }
}
