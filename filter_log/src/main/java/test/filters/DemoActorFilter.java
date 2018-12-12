package test.filters;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/9
 */
public class DemoActorFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        /**
         * 只打印log中包含指定字符串的log
         */
        if(event.getMessage().contains("DemoActor")){
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
