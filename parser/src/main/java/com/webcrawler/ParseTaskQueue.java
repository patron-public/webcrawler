package com.webcrawler;

import com.webcrawler.parser.Parser;
import com.webcrawler.task.ParseTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskQueue {

    private static final Logger log = LoggerFactory.getLogger(ParseTaskQueue.class);
    private static ConcurrentLinkedQueue<ParseTask> queue = new ConcurrentLinkedQueue<ParseTask>();

    public static void putTasks(List<ParseTask> taskList) {

        for (ParseTask task : taskList) {
            log.info("Adding task :" + task.toString());
            queue.offer(task);

        }
    }

    public static <T extends Parser<M>, M> ParseTask<T, M> takeTask() {
        return queue.poll();
    }
}
