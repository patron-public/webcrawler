package com.webcrawler.provider.pages;

import com.webcrawler.parser.Parser;
import com.webcrawler.provider.ParseTaskProvider;
import com.webcrawler.task.ParseTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class PagesProvider<P extends Parser<R>, R> implements ParseTaskProvider<P, R> {

    protected abstract Set<URL> getUrls();

    public abstract void addUrl(URL url);

    public List<ParseTask<P,R>> getTasks() {
        List<ParseTask<P, R>> result = new ArrayList<ParseTask<P, R>>();
        for (URL url : getUrls()) {
            result.add(new ParseTask<P, R>(url, getParser(), getResultProcessor()));
        }
        return result;
    }

}
