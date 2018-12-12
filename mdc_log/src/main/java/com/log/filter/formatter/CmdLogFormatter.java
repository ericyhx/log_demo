package com.log.filter.formatter;


import com.log.filter.log.LogFormatter;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/27
 */
public class CmdLogFormatter implements LogFormatter {
    private String agvCode;
    private String moduleName = "rcs-command";
    private String[] contents;

    private CmdLogFormatter(String agvCode, String moduleName, String... content) {
        this.agvCode = agvCode;
        if (moduleName != null && moduleName.trim().length() > 0) {
            this.moduleName = moduleName;
        }
        contents = new String[content.length + 1];
        contents[0] = agvCode;
        for (int i = 1; i < contents.length; i++) {
            contents[i] = content[i - 1];
        }
    }

    public static CmdLogFormatter formatter(String agvCode, String moduleName, boolean isModuleName, String... content) {
        return new CmdLogFormatter(agvCode, moduleName, content);
    }

    public static CmdLogFormatter formatter(String agvCode, String... content) {
        return formatter(agvCode, null, false, content);
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