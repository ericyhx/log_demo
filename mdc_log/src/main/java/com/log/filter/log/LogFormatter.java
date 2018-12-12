package com.log.filter.log;

import lombok.NonNull;

public interface LogFormatter {
    String DEFAULT_MODULE = "log_all";

    /**
     * 小车ID
     * 如果不为null,该日志会打印在指定文件夹下面,比如logs/agv_id
     * 如果为null,该日志会打印在logs/server
     *
     * @return 小车ID
     */
    default String getAgvId() {
        return null;
    }

    /**
     * 模块ID,可以指定module名称
     * 如果不为null,该日志会打印在日志名称中,比如logs/agv_id/${agv_id}_task.log
     * 如果为null,"","   ",该日志会打印在logs/agv_id/${agv_id}_all.log
     *
     * @return 模块名称
     */
    default String getModule() {
        return DEFAULT_MODULE;
    }

    /**
     * 打印的具体内容,根据模块区分
     *
     * @return {@link Object}
     */
    @NonNull
    Object[] getObjects();
}
