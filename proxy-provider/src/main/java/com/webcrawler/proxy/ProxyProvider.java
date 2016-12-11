package com.webcrawler.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pavel.yakimchyk on 10.12.2016.
 */
public class ProxyProvider implements ContentProvider<String>, Refreshable {

    private ProxyProvider() {
    };

    private static ProxyProvider proxyProvider;

    public static ProxyProvider getInst() {
        if (proxyProvider == null)
            proxyProvider = new ProxyProvider();
        return proxyProvider;
    }

    private static final Logger log = LoggerFactory.getLogger(ProxyProvider.class);

    public void updateContent() {
        log.info("Proxy List updated");
    }

    public Set<String> getContent() {
        log.info("Sample proxy List returned");
        return new HashSet<String>(Arrays.asList("Sample proxy 1", "Sample proxy 2"));
    }
}
