package com.webcrawler.provider.recent;

import com.webcrawler.parser.Parser;
import com.webcrawler.provider.ParseTaskProvider;
import com.webcrawler.task.ParseTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class RecentProvider<T extends Parser>  implements ParseTaskProvider<T>  {

    protected abstract Set<URL> getRecentUrls();

    public List<ParseTask<T>> getTasks() {
        List<ParseTask<T>> result = new ArrayList<ParseTask<T>>();

        for (URL url : getRecentUrls()) {
            result.add(new ParseTask<T>(url, getParser()));
        }
        return result;
    }

}
