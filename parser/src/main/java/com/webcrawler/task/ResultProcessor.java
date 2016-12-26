package com.webcrawler.task;

/**
 * Created by Pavel on 26.12.2016.
 */
public interface ResultProcessor<R> {
    void processResult(R result);
}
