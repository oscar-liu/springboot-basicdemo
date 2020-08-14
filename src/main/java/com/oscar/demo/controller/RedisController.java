package com.oscar.demo.controller;

import com.oscar.demo.utils.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RequestMapping("/redis")
@RestController
public class RedisController {
    private static int ExpireTime = 60; // 过期时间

    @Autowired
    private RedisUtil redisUtil;

    private static org.apache.log4j.Logger logger = Logger.getLogger(RedisController.class);

    @RequestMapping("set")
    public boolean redisset(String key, String value) {

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
        logger.info("当前时间" + new Date() );
//        Log.info("redis set key=" + key + ",value=" + value);
        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
