package com.webcrawler.task;

import com.webcrawler.WEBSITE;
import com.webcrawler.parser.Parser;

import java.net.Proxy;
import java.net.URL;
import java.util.Set;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTask<T extends Parser> {

    private T parser;
    private WEBSITE website;
    private URL url;
    private Proxy proxy;
    private Set<Proxy> failedProxies;
    private String data;

    public ParseTask(URL url, T parser){
        this.parser = parser;
        this.url = url;
    }

    public WEBSITE getWebsite() {
        return website;
    }

    public URL getUrl() {
        return url;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public Set<Proxy> getFailedProxies() {
        return failedProxies;
    }

    public String getData() {
        return data;
    }

    public T getParser() {
        return parser;
    }
}
