package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.AdvertiesmentDao;
import com.mcw.mycarwash.Model.Advertiesments;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class AdvertiesmetDaoImpl implements AdvertiesmentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Advertiesments> getAdvertiesmentList() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Advertiesments> query = currentSession.createQuery("FROM Advertiesments ", Advertiesments.class);
        List<Advertiesments> advertiesmentsList = query.getResultList();
        return advertiesmentsList;
    }

    @Override
    public Advertiesments get(String id) {
        Session session = entityManager.unwrap(Session.class);
        Advertiesments advertiesments = session.get(Advertiesments.class, id);
        return advertiesments;
    }

    @Override
    public void save_advertiesment(Advertiesments advertiesments) {
        Session session = entityManager.unwrap(Session.class);
        session.save(advertiesments);
    }
}
