package com.ss.quickStart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController  {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerController.class);
    @RequestMapping("log")
    public Boolean log(){
        LOGGER.trace("trace日志记录");
        LOGGER.debug("debug日志记录");
        LOGGER.info("info日志记录");
        LOGGER.warn("warn日志记录");
        LOGGER.error("error日志记录");
        return true;
    }
}
