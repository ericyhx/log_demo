package com.kc.test.bean;

import ch.qos.logback.core.FileAppender;

import java.io.IOException;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/27
 */
public class MyFileAppender<E> extends FileAppender<E> {
    @Override
    public void openFile(String file_name) throws IOException {
        if(!file_name.trim().equals("log.all")){
            file_name=file_name.replace("_","/");
        }
        super.openFile(file_name);
    }
}
