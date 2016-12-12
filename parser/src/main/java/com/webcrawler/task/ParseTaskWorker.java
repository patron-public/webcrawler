package com.webcrawler.task;

import com.webcrawler.ParseTaskQueue;
import com.webcrawler.loader.PageLoader;
import com.webcrawler.loader.UrlConnectionLoader;
import com.webcrawler.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskWorker<P extends Parser<R>, R> implements Runnable {
    private static PageLoader loader = new UrlConnectionLoader();
    private static final Logger log = LoggerFactory.getLogger(ParseTaskQueue.class);

    public void run() {
        while (true) {
            try {
                ParseTask<P, R> task = ParseTaskQueue.takeTask();
                if (task == null) {
                    Thread.sleep(5000);
                } else {
                    log.info("Start Processing task: " + task.toString());
                    URL url = task.getUrl();
                    String page = loader.getText(url);

                    P parser = task.getParser();
                    R result = parser.parse(page);

                    ResultProcessor<R> processor = task.getResultProcessor();
                    processor.processResult(result);
                }
            } catch (IOException e) {
                //TODO: log error
                e.printStackTrace();
            } catch (ParseException e) {
                //TODO: log error
                e.printStackTrace();
            } catch (InterruptedException e) {
                //TODO: log error
                e.printStackTrace();
            }
        }
    }
}
