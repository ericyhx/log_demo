package com.log.filter.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/12
 */
public class LogFileNameUtil {
    private static String XPATTERN = "%X\\{(.+?)}";
    public static String parseFileName(String file_name){
            String filename = file_name;

            Matcher matcher = Pattern.compile(XPATTERN).matcher(file_name);

            if (matcher.find()) {
                String value ="";
                if (!filename.contains("@")) {
                    value = LogFormatter.DEFAULT_MODULE;
                }else {
                    final String[] ss = filename.split("/");
                    StringBuffer sb=new StringBuffer();
                    for (int i = 0; i < ss.length; i++) {
                        if(ss[i].contains("@")){
                            String[] s = ss[i].split("@");
                            ss[i]=s[0];
                            value=s[1];
                        }
                        sb.append("/").append(ss[i]);
                    }
                    filename=sb.toString().replaceFirst("/","");
                }
                filename=filename.replace(matcher.group(),value);
            }
            return filename;
    }
}
