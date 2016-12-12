package com.webcrawler.dao;

import com.webcrawler.ParseTaskQueue;
import com.webcrawler.model.AdModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class PageDao implements Dao<AdModel>{

    private static final Logger log = LoggerFactory.getLogger(ParseTaskQueue.class);

    public void save(AdModel entity) {
        log.info("Saving model: " + entity.toString());
    }
}
