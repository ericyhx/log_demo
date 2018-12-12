package com.log.filter.log;

import ch.qos.logback.core.rolling.RollingFileAppender;

import java.io.IOException;

import static com.log.filter.log.LogFileNameUtil.parseFileName;

public class MultiKeyRollingFileAppender<E> extends RollingFileAppender<E> {
    @Override
    public void openFile(String file_name) throws IOException {
        final String filename = parseFileName(file_name);
        super.openFile(filename);
    }


    @Override
    public void setFile(String file) {
        final String filename = parseFileName(file);
        super.setFile(filename);
    }
}
