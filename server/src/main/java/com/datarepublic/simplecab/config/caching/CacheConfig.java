package com.datarepublic.simplecab.config.caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@ComponentScan("com.datarepublic.simplecab")
public class CacheConfig {

	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("medallionCounts");
    }
	
	
}
	