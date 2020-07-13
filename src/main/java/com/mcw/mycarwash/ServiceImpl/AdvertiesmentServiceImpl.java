package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.AdvertiesmentDao;
import com.mcw.mycarwash.Model.Advertiesments;
import com.mcw.mycarwash.Service.AdvertiesmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertiesmentServiceImpl implements AdvertiesmenService {

    @Autowired
    private AdvertiesmentDao advertiesmentDao;

    @Transactional
    @Override
    public List<Advertiesments> getAdvertiesmentList() {

        return advertiesmentDao.getAdvertiesmentList();
    }

    @Transactional
    @Override
    public Advertiesments get(String id) {
        return advertiesmentDao.get(id);
    }

    @Transactional
    @Override
    public void save_advertiesment(Advertiesments advertiesments) {
        advertiesmentDao.save_advertiesment(advertiesments);
    }
}
