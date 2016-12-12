package com.webcrawler.provider.index;

import com.webcrawler.parser.Parser;
import com.webcrawler.provider.ParseTaskProvider;
import com.webcrawler.task.ParseTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class IndexProvider<P extends Parser<R>, R> implements ParseTaskProvider<P, R>  {

    protected abstract URL getIndexUrl();

    public List<ParseTask<P, R>> getTasks() {
        List<ParseTask<P, R>> result = new ArrayList<ParseTask<P, R>>();
        result.add(new ParseTask<P, R>(getIndexUrl(), getParser(), getResultPrecessor()));
        return result;
    }
}
