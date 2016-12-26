package com.webcrawler.provider.pages;

import com.webcrawler.model.AdField;
import com.webcrawler.parser.AvPageParser;
import com.webcrawler.task.AvPageResultProcessor;
import com.webcrawler.task.ResultProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AvOutdatedProvider extends PagesProvider<AvPageParser, Map<AdField, String>> {

    private static final Logger log = LoggerFactory.getLogger(AvOutdatedProvider.class);
    private static final ResultProcessor<Map<AdField, String>> PROCESSOR = new AvPageResultProcessor();
    private static final AvPageParser PARSER = new AvPageParser();

    protected Set<URL> getUrls() {
        Set<URL> urls = new HashSet<URL>();
//      TODO:  implement logic to get pages urls from database;
        try {
            urls.add(new URL("https://cars.av.by/outdated/12360240"));
            urls.add(new URL("https://cars.av.by/outdated/12360209"));
            urls.add(new URL("https://cars.av.by/outdated/12360208"));

        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }

        return urls;
    }

    public void addUrl(URL url) {
        throw new UnsupportedOperationException();
    }

    public AvPageParser getParser() {
        return PARSER;
    }

    public ResultProcessor<Map<AdField, String>> getResultProcessor() {
        return PROCESSOR;
    }
}
