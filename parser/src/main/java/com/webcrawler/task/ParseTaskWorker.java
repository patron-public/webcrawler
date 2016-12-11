package com.webcrawler.task;

import com.webcrawler.ParseTaskQueue;
import com.webcrawler.converter.ResultToEntityConverter;
import com.webcrawler.dao.PageDao;
import com.webcrawler.loader.PageLoader;
import com.webcrawler.loader.UrlConnectionLoader;
import com.webcrawler.model.AdField;
import com.webcrawler.model.AdModel;
import com.webcrawler.model.IndexField;
import com.webcrawler.parser.AvIndexParser;
import com.webcrawler.parser.IndexParser;
import com.webcrawler.parser.PageParser;
import com.webcrawler.parser.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ParseTaskWorker<T extends Parser<M>, M> implements Runnable {
    private static PageLoader loader = new UrlConnectionLoader();
    PageDao dao = new PageDao();

    public static <T extends Parser<M>, M> void processQueue() {


    }

    public void run() {
        while (true) {
            try {
                ParseTask<T> task = ParseTaskQueue.takeTask();
                String page = loader.getText(task.getUrl());
                T parser = task.getParser();
                M result = parser.parse(page);
                saveResult(parser, result);

            } catch (IOException e) {
                //TODO: log error
                e.printStackTrace();
            } catch (ParseException e) {
                //TODO: log error
                e.printStackTrace();
            }
        }
    }

    private<T, M> void saveResult(T parser, M result) {
        if (parser instanceof IndexParser){
            List<Map<IndexField, String>> indexResult =  (List<Map<IndexField, String>>) result;

            addResultsToQueue(indexResult);
        }
        if (parser instanceof PageParser){
            Map<AdField, String> pageResult =  (Map<AdField, String>) result;
            AdModel model = new ResultToEntityConverter().convert(pageResult);
            dao.save(model);
        }
    }

    private void addResultsToQueue(List<Map<IndexField, String>> indexResult) {
        List<ParseTask> tasks = new ArrayList<ParseTask>();
        for (Map<IndexField, String> newPage: indexResult){
            try {
                URL url = new URL(newPage.get(IndexField.URL));
                tasks.add(new ParseTask(url, new AvIndexParser()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ParseTaskQueue.putTasks(tasks);
    }
}
