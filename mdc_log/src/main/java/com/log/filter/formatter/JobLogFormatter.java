package com.log.filter.formatter;


import com.log.filter.log.LogFormatter;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/28
 */
public class JobLogFormatter implements LogFormatter {
    private String agvCode;
    private String moduleName = "rcs-job";
    private String[] contents;

    private JobLogFormatter(String agvCode, String method, String... contents) {
        this.agvCode = agvCode;
        this.contents = new String[contents.length + 2];
        this.contents[0] = agvCode;
        this.contents[1] = method;
        for (int i = 0; i < contents.length; i++) {
            this.contents[i + 2] = contents[i];
        }
    }

    public static JobLogFormatter formatter(String agvCode, String method, String... contents) {
        return new JobLogFormatter(agvCode, method, contents);
    }

    @Override
    public String getAgvId() {
        return agvCode;
    }

    @Override
    public String getModule() {
        return moduleName;
    }

    @Override
    public Object[] getObjects() {
        return contents;
    }
}
