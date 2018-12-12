package com.log.filter.log;

import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;

import static com.log.filter.log.LogFileNameUtil.*;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/12
 */
public class MyTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    private static String XPATTERN = "%X\\{(.+?)}";
    @Override
    public void setFileNamePattern(String fnp) {

        super.setFileNamePattern(parseFileName(fnp));
    }
}
