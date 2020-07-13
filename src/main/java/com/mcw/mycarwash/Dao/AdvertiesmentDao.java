package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.Advertiesments;

import java.util.List;

public interface AdvertiesmentDao {
    List<Advertiesments> getAdvertiesmentList();

    Advertiesments get(String id);

    void save_advertiesment(Advertiesments advertiesments);
}
