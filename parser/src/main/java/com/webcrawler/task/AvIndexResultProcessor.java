package com.webcrawler.task;

import com.webcrawler.ParseTaskQueue;
import com.webcrawler.model.AdField;
import com.webcrawler.model.IndexField;
import com.webcrawler.parser.AvPageParser;
import com.webcrawler.provider.pages.AvRecentProvider;
import com.webcrawler.provider.pages.PagesProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Pavel on 26.12.2016.
 */
public class AvIndexResultProcessor implements ResultProcessor<List<Map<IndexField, String>>> {

    PagesProvider taskProvider = new AvRecentProvider();

    public void processResult(List<Map<IndexField, String>> results) {
        for (Map<IndexField, String> result : results) {
            try {
                String url = result.get(IndexField.URL);
                taskProvider.addUrl(new URL(url));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        ParseTaskQueue.putTasks(taskProvider.getTasks());
    }
}
