package com.webcrawler;

import com.webcrawler.parser.Parser;
import com.webcrawler.task.ParseTask;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskQueue {

    private static ParseTaskQueue singleton;

    private static ArrayBlockingQueue<ParseTask> queue = new ArrayBlockingQueue<ParseTask>(10000);

    public static void putTasks(List<ParseTask> taskList) {
        for (ParseTask task : taskList) {
            try {
                queue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T extends Parser> ParseTask<T> takeTask() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
