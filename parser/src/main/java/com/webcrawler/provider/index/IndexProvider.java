package com.webcrawler.provider.index;

import com.webcrawler.parser.Parser;
import com.webcrawler.provider.ParseTaskProvider;
import com.webcrawler.task.ParseTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class IndexProvider<T extends Parser> implements ParseTaskProvider<T> {

    protected abstract URL getIndexUrl();

    public List<ParseTask<T>> getTasks() {
        List<ParseTask<T>> result = new ArrayList<ParseTask<T>>();
        result.add(new ParseTask<T>(getIndexUrl(), getParser()));
        return result;
    }
}
