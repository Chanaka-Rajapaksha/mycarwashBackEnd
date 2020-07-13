package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Model.Advertiesments;

import java.util.List;

public interface AdvertiesmenService {

    List<Advertiesments> getAdvertiesmentList();

    Advertiesments get(String id);

    void save_advertiesment(Advertiesments advertiesments);

}
