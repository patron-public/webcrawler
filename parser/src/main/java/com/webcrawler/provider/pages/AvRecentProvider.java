package com.webcrawler.provider.pages;

import com.webcrawler.model.AdField;
import com.webcrawler.parser.AvPageParser;
import com.webcrawler.task.AvPageResultProcessor;
import com.webcrawler.task.ResultProcessor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AvRecentProvider extends PagesProvider<AvPageParser, Map<AdField, String>> {

    private static final ResultProcessor<Map<AdField, String>> PROCESSOR = new AvPageResultProcessor();
    private static final AvPageParser PARSER = new AvPageParser();

    protected Set<URL> getUrls() {
        Set<URL> urls = new HashSet<URL>();
        //TODO: implement logic to get pages urls;
        try {
            URL url = new URL("http://onliner.by/");
            urls.add(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return urls;
    }


    public AvPageParser getParser() {
        return PARSER;
    }

    public ResultProcessor<Map<AdField, String>> getResultPrecessor() {
        return PROCESSOR;
    }
}
