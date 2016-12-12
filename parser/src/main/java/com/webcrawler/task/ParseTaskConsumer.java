package com.webcrawler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskConsumer {

    private static final Logger log = LoggerFactory.getLogger(ParseTaskConsumer.class);

    public static void processQueue(int poolSize) {
        log.info("======Starting Threads=====:");

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.execute(new ParseTaskWorker());
            log.info("Thread started: #" + i);
        }

        log.info("======Starting Threads=====:");

//        TODO: pool termination
    }

}
