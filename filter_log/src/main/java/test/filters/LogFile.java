package test.filters;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/11
 */
@Slf4j
@Accessors(chain = true)
public class LogFile {
    private String user;
    @Setter
    private String method;
    @Setter
    private String content;

    public LogFile(String user,String userid) {
        this.user = user;
        MDC.put("userid",userid);
    }
    public void info(){
        log.info("[{}][{}]|{}",user,method,content);
    }
    public void error(){
        log.error("[{}][{}]|{}",user,method,content);
    }
    public void debug(){
        log.debug("[{}][{}]|{}",user,method,content);
    }
}
