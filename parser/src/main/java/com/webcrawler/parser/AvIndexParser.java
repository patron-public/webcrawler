package com.webcrawler.parser;

import com.webcrawler.model.IndexField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class AvIndexParser extends IndexParser {

    public List<Map<IndexField, String>> parse(String page) {
        List<Map<IndexField, String>> result = new ArrayList<Map<IndexField, String>>();
        result.addAll(getSample());
        //TODO: implement parse logic
        return result;
    }


    public  List<Map<IndexField, String>> getSample() {
        List<Map<IndexField, String>> samples = new ArrayList<Map<IndexField, String>>();
        Map<IndexField, String> sample1 = new HashMap<IndexField, String>();
        sample1.put(IndexField.URL, "https://cars.av.by/bmw/x5-e70/11960788");
        sample1.put(IndexField.DATE_POSTED, "1200");
        sample1.put(IndexField.MODEL, "E60");
        sample1.put(IndexField.VENDOR, "BMW");
        sample1.put(IndexField.COMMENT, "comment");
        samples.add(sample1);

        Map<IndexField, String> sample2 = new HashMap<IndexField, String>();
        sample2.put(IndexField.URL, "https://cars.av.by/volkswagen/passat-b7/12359599");
        sample2.put(IndexField.DATE_POSTED, "121200");
        sample2.put(IndexField.MODEL, "FOX");
        sample2.put(IndexField.VENDOR, "VW");
        sample2.put(IndexField.COMMENT, "comment");
        samples.add(sample2);

        return samples;
    }
}
