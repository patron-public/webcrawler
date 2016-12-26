package com.webcrawler;

import com.webcrawler.provider.index.AvIndexProvider;
import com.webcrawler.provider.index.IndexProvider;
import com.webcrawler.provider.pages.AvOutdatedProvider;
import com.webcrawler.provider.pages.PagesProvider;
import com.webcrawler.proxy.ProxyProvider;
import com.webcrawler.task.ParseTaskConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by pavel.yakimchyk on 10.12.2016.
 */

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 20000, initialDelay = 3000)
    public void updateProxyList() {
        log.info("Updating Proxy List");
        ProxyProvider.getInst().updateContent();
    }

    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void updateIndexTasks() {
        for (IndexProvider taskProvider : new IndexProvider[]{
                new AvIndexProvider(),
        }) {
            log.info("Updating New Pages List");
            ParseTaskQueue.putTasks(taskProvider.getTasks());
        }
    }

    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void updateOutdatedPagesTasks() {
        for (PagesProvider taskProvider : new PagesProvider[]{
                new AvOutdatedProvider(),
        }) {
            log.info("Updating Outdated Pages List");
            ParseTaskQueue.putTasks(taskProvider.getTasks());
        }
    }

    @Scheduled(fixedDelay = 100000000, initialDelay = 3000)
    public void processTaskQueue() {
        int poolSize = 1;
        log.info("Start processing queue");
        ParseTaskConsumer.processQueue(poolSize);

    }


}
