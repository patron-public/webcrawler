package com.webcrawler.provider.recent;

import com.webcrawler.parser.AvPageParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class AvRecentProvider extends RecentProvider<AvPageParser> {

    protected Set<URL> getRecentUrls() {
        Set<URL> urls = new HashSet<URL>();
        //TODO: implement logic to get outdated urls;
        try {
            URL url = new URL("http://onliner.by/");
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
