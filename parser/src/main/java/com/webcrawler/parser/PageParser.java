package com.webcrawler.parser;

import com.webcrawler.model.AdField;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public abstract class  PageParser implements Parser <Map<AdField, String>>{

    public abstract Map<AdField, String> parse(String page) throws ParseException;
}
