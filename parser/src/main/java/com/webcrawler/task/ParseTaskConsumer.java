package com.webcrawler.task;

import com.webcrawler.task.ParseTaskWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskConsumer {


    public static void processQueue(int poolSize) {


        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        for (int i=0; i < poolSize; i++){
            pool.execute(new ParseTaskWorker());
        }

        pool.shutdown();
        while (!pool.isTerminated()){

        }
        //TODO: log termination
    }

}
