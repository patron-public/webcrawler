package com.webcrawler.converter;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface Converter<T, M> {
    M convert (T original);
}
