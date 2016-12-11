package com.webcrawler.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pavel.yakimchyk on 10.12.2016.
 */
@RestController
public class RestExample {
    private static final Logger log = LoggerFactory.getLogger(RestExample.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home() {
        log.info("Home page visited");
        return "Home page";
    }

}