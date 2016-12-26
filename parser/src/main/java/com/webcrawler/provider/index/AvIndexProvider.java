package com.webcrawler.provider.index;

import com.webcrawler.model.IndexField;
import com.webcrawler.parser.AvIndexParser;
import com.webcrawler.task.AvIndexResultProcessor;
import com.webcrawler.task.ResultProcessor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AvIndexProvider extends IndexProvider<AvIndexParser, List<Map<IndexField, String>>> {

    private static final AvIndexParser PARSER = new AvIndexParser();
    private static final ResultProcessor<List<Map<IndexField, String>>> PROCESSOR = new AvIndexResultProcessor();

    protected URL getIndexUrl() {
        try {
            return new URL("https://cars.av.by/search");
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public AvIndexParser getParser() {
        return PARSER;
    }

    public ResultProcessor<List<Map<IndexField, String>>> getResultProcessor() {
        return PROCESSOR;
    }

}
