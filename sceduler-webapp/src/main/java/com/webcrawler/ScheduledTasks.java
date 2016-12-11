package com.webcrawler;

import com.webcrawler.provider.index.AvIndexProvider;
import com.webcrawler.provider.index.IndexProvider;
import com.webcrawler.provider.outdated.AvOutdatedProvider;
import com.webcrawler.provider.outdated.OutdatedProvider;
import com.webcrawler.provider.recent.RecentProvider;
import com.webcrawler.proxy.ProxyProvider;
import com.webcrawler.provider.recent.AvRecentProvider;
import com.webcrawler.provider.ParseTaskProvider;
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

    @Scheduled(fixedRate = 20000)
    public void updateProxyList() {
        log.info("Updating Proxy List");
        ProxyProvider.getInst().updateContent();
    }

    @Scheduled(fixedRate = 3000)
    public void updateRecentPagesTasks() {
        for (ParseTaskProvider taskProvider : new RecentProvider[]{
                new AvRecentProvider(),
        }) {
            ParseTaskQueue.putTasks(taskProvider.getTasks());
            log.info("Updating New Pages List");
        }

    }

    @Scheduled(fixedRate = 3000)
    public void updateIndexTasks() {
        for (ParseTaskProvider taskProvider : new IndexProvider[]{
                new AvIndexProvider(),
        }) {
            ParseTaskQueue.putTasks(taskProvider.getTasks());
            log.info("Updating New Pages List");
        }

    }

    @Scheduled(fixedRate = 10000)
    public void updateOutdatedPagesTasks() {
        for (ParseTaskProvider taskProvider : new OutdatedProvider[]{
                new AvOutdatedProvider(),
        }) {
            ParseTaskQueue.putTasks(taskProvider.getTasks());
            log.info("Updating New Pages List");
        }

        log.info("Updating Outdated Pages List");
    }

    @Scheduled(fixedRate = 10000)
    public void peocessTaskQueue() {
        int poolSize = 1;
        ParseTaskConsumer.processQueue(poolSize);
        log.info("Processing queue");
    }


}
