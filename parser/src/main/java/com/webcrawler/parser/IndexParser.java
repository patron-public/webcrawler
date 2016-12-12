package com.webcrawler.parser;

import com.webcrawler.model.AdField;
import com.webcrawler.model.IndexField;

import java.util.List;
import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public abstract class IndexParser implements Parser<List<Map<IndexField, String>>> {

    //public abstract List<Map<IndexField, String>> parse(String page);
}
