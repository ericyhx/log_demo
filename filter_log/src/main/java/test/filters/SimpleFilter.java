package test.filters;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/9
 */
public class SimpleFilter  extends Filter<ILoggingEvent>
{
    @Override
    public FilterReply decide(ILoggingEvent event) {

        if (event.getMessage().contains("come into")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;

        }
    }
}
