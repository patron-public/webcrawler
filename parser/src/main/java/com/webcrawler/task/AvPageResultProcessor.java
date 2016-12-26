package com.webcrawler.task;

import com.webcrawler.converter.Converter;
import com.webcrawler.converter.ResultToEntityConverter;
import com.webcrawler.dao.PageDao;
import com.webcrawler.model.AdField;
import com.webcrawler.model.AdModel;

import java.util.Map;

/**
 * Created by Pavel on 26.12.2016.
 */
public class AvPageResultProcessor implements ResultProcessor<Map<AdField, String>>{
    PageDao dao = new PageDao();
    Converter<Map<AdField, String>, AdModel> converter = new ResultToEntityConverter();

    public void processResult(Map<AdField, String> result) {
        dao.save(converter.convert(result));
    }
}
