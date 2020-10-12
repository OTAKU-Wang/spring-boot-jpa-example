package com.neo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author wangmaoshuai
 */
@Configuration
@Slf4j
public class UserAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        try {
            return Optional.of("admin");
        }catch (Exception e){
            log.error("UserAuditor get use info error !",e);
            return Optional.empty();
        }
    }
}
