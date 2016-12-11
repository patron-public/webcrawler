package com.webcrawler.provider;

import com.webcrawler.parser.Parser;
import com.webcrawler.task.ParseTask;

import java.util.List;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface ParseTaskProvider<T extends Parser> {

    List<ParseTask<T>> getTasks();

    T getParser();

}
