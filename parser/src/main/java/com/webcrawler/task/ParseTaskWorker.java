package com.webcrawler.task;

import com.webcrawler.ParseTaskQueue;
import com.webcrawler.loader.PageLoader;
import com.webcrawler.loader.UrlConnectionLoader;
import com.webcrawler.parser.Parser;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskWorker<T extends Parser<M>, M> implements Runnable {
    private static PageLoader loader = new UrlConnectionLoader();


    public static <T extends Parser<M>, M> void processQueue() {


    }

    public void run() {
        while (true) {
            try {
                ParseTask<T> task = ParseTaskQueue.takeTask();
                String page = loader.getText(task.getUrl());
                T parser = task.getParser();
                M result = parser.parse(page);


            } catch (IOException e) {
                //TODO: log error
                e.printStackTrace();
            } catch (ParseException e) {
                //TODO: log error
                e.printStackTrace();
            }
        }
    }
}
