package com.webcrawler.parser;

import java.text.ParseException;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface Parser<R> {
    R parse(String page)throws ParseException;
}
