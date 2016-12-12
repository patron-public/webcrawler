package com.webcrawler.provider;

import com.webcrawler.parser.Parser;
import com.webcrawler.task.ParseTask;
import com.webcrawler.task.ResultProcessor;

import java.util.List;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface ParseTaskProvider<P extends Parser<R>, R> {

    List<ParseTask<P, R>> getTasks();

    P getParser();

    ResultProcessor<R> getResultPrecessor();

}
