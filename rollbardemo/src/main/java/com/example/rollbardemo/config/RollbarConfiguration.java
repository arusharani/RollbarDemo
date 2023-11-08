package com.example.rollbardemo.config;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import com.rollbar.notifier.config.ConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RollbarConfiguration {
    private final String token ="440382f207be4812a8086c60348c65d2";

    @Bean
    public Rollbar getRollbar() {
        return new Rollbar(getConfig());
    }

    public Config getConfig() {
        return ConfigBuilder.withAccessToken(token)
                .environment("local").build();
    }

}