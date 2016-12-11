package com.webcrawler.provider.index;

import com.webcrawler.parser.AvPageParser;

import java.net.MalformedURLException;
import java.net.URL;

public class AvIndexProvider extends IndexProvider<AvPageParser> {

    protected URL getIndexUrl() {
        //TODO: fix to real page
        try {
            return new URL("http://shop.by/");
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public AvPageParser getParser() {
        //TODO: fix to be singleton
        return new AvPageParser();
    }

}
