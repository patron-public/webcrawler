package com.webcrawler.dao;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface Dao<M> {
    void save(M entity);
}
