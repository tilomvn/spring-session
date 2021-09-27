package com.spring.session.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.cache.GemfireCacheManager;

import com.spring.session.entities.ResponseModel;

@Configuration
@EnableCaching
class CachesConfig {
	
	@Bean
	CacheManager gemFireCacheManager(GemFireCache gemfireCache, ClientCache clientCache) {
		GemfireCacheManager gemfireCacheManager = new GemfireCacheManager();
        gemfireCacheManager.setCache(gemfireCache);

        Set<Region<?, ?>> regions = new HashSet<>();
        //regions.add(clientCache.getRegion("SpringSession")); //EnableGemFireHttpSession
        regions.add(clientCache.getRegion("ResponseModel"));//EnableEntityDefinedRegions

        gemfireCacheManager.setRegions(regions);
        
        return gemfireCacheManager;
	}
}
