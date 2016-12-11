package com.webcrawler.parser;

import com.webcrawler.model.AdField;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class AvPageParser extends PageParser {

    public Map<AdField, String> parse(String page) {
        Map<AdField, String> result = new HashMap<AdField, String>();
        result.put(AdField.COMMENT, "comment");
        result.put(AdField.PRICE, "2000");
        result.put(AdField.VENDOR, "Audi");
        result.put(AdField.MODEL, "100");
        result.put(AdField.DATE_POSTED, "1000");
        //TODO: implement parse logic
        return result;
    }
}
