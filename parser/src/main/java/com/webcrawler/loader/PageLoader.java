package com.webcrawler.loader;

import java.io.IOException;
import java.net.URL;

/**
 * Created by pavel.yakimchyk on 11.12.2016.
 */
public interface PageLoader {
    String getText(URL url) throws IOException;
}
