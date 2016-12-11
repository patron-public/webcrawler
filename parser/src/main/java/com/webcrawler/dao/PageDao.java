package com.webcrawler.dao;

import com.webcrawler.model.AdModel;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class PageDao implements Dao<AdModel>{


    public void save(AdModel entity) {
        System.out.println(entity.toString());
    }
}
