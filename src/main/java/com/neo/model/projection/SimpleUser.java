package com.neo.model.projection;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author wangmaoshuai
 * 获取用户的部分信息
 */
public interface SimpleUser {
    /**
     * 获取用户名和年龄
     * @return 结果
     */
    @Value("#{target.userName+ ' '+target.age}")
    String getNameAndAge();
}
