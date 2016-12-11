package com.webcrawler.proxy;

import java.util.Set;

/**
 * Created by pavel.yakimchyk on 10.12.2016.
 */
public interface ContentProvider<T> {
    Set<T> getContent();
}
