package com.webcrawler.task;

import com.webcrawler.parser.Parser;

import java.net.Proxy;
import java.net.URL;
import java.util.Set;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTask<P extends Parser<R>, R> {

    private P parser;
    private URL url;
    private Proxy proxy;
    private Set<Proxy> failedProxies;
    private ResultProcessor<R> resultProcessor;

    public ParseTask(URL url, P parser, ResultProcessor<R> resultProcessor){
        this.parser = parser;
        this.url = url;
        this.resultProcessor = resultProcessor;
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

    public P getParser() {
        return parser;
    }

    public ResultProcessor<R> getResultProcessor() {
        return resultProcessor;
    }

    @Override
    public String toString() {
        return "ParseTask{" +
                "parser=" + parser.getClass().getSimpleName() +
                ", url=" + url +
                ", proxy=" + proxy +
                ", failedProxies=" + failedProxies +
                ", resultProcessor='" + resultProcessor + '\'' +
                '}';
    }
}
