package com.webcrawler.provider.outdated;

import com.webcrawler.parser.AvPageParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class AvOutdatedProvider extends OutdatedProvider<AvPageParser> {

    protected Set<URL> getOutdatedUrls() {
        Set<URL> urls = new HashSet<URL>();
//      TODO:  implement logic to get outdated urls;
        try {
            URL url = new URL("http://tut.by/");
            urls.add(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return urls;
    }

    public AvPageParser getParser() {
        return new AvPageParser();
    }
}
