package com.webcrawler.converter;

import com.webcrawler.model.AdField;
import com.webcrawler.model.AdModel;

import java.util.Map;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public class ResultToEntityConverter implements Converter<Map<AdField, String>, AdModel> {
    public AdModel convert(Map<AdField, String> original) {
        AdModel adModel= new AdModel();
        adModel.setComment(original.get(AdField.COMMENT));
        adModel.setDatePosted(Long.parseLong(original.get(AdField.DATE_POSTED)));
        adModel.setModel(original.get(AdField.MODEL));
        adModel.setVendor(original.get(AdField.VENDOR));
        adModel.setPrice(Integer.parseInt(original.get(AdField.PRICE)));
        return adModel;
    }
}
