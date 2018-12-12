package com.log.filter.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.spi.LocationAwareLogger;

import java.util.Arrays;

import static org.slf4j.spi.LocationAwareLogger.ERROR_INT;

@Slf4j
public class LogUtils {

    private static final String FQCN = LogUtils.class.getName();

    public static void trace(LogFormatter formatter) {
        doLog(formatter, LocationAwareLogger.TRACE_INT, null);
    }

    public static void debug(LogFormatter formatter) {
        doLog(formatter, LocationAwareLogger.DEBUG_INT, null);
    }

    public static void info(LogFormatter formatter) {
        doLog(formatter, LocationAwareLogger.INFO_INT, null);
    }

    public static void warn(LogFormatter formatter) {
        doLog(formatter, LocationAwareLogger.WARN_INT, null);
    }

    public static void error(LogFormatter formatter, Throwable throwable) {
        doLog(formatter, ERROR_INT, throwable);
    }

    private static void doLog(LogFormatter formatter, int level, Throwable throwable) {
        Object[] logObjects = formatter.getObjects();

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements[3];
        LocationAwareLogger logger = (LocationAwareLogger)LoggerFactory.getLogger(element.getClassName());

        //
        if (formatter.getAgvId() != null) {
            MDC.put("agvId", formatter.getAgvId().concat("@").concat(formatter.getModule()));
        }
//        if (formatter.getModule() != null) {
//            MDC.put("module", formatter.getModule());
//        }

        StringBuilder format = new StringBuilder();
        Arrays.asList(logObjects).forEach(o -> format.append("[{}]"));

        logger.log(null, FQCN, level, format.toString(), logObjects, throwable);

        MDC.remove("agvId");
//        MDC.remove("module");
    }
}