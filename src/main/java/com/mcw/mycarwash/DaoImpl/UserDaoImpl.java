package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.UserDao;
import com.mcw.mycarwash.Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplateName;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateName = new NamedParameterJdbcTemplate(dataSource);
    }

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

    @Override
    public User logingCheck(User user) {
        User newuser = new User();
        //String query = "SELECT * FROM USER WHERE user_name ='"+user.getUserName()+"' AND client_id = '"+user.getClientId()+"' AND isactive='1'";
        String query = "SELECT * FROM USER WHERE user_name ='"+user.getUserName()+"' AND user_password = '"+user.getUserPassword()+"'  AND client_id = '"+user.getClientId()+"' AND isactive='1'";
        List<User> userList = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(User.class));
        for(User user1 : userList){
            newuser = user1;
        }
        return newuser;
    }
}
