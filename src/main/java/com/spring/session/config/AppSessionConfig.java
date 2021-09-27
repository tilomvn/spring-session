package com.spring.session.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

@ClientCacheApplication(name = "ClientCacheApplication")
@EnableEntityDefinedRegions(
		poolName = ClientRegionFactoryBean.DEFAULT_POOL_NAME, 
		basePackages = {"com.spring.session.entities"}, // A specified data regions, can be used to cache data.
		clientRegionShortcut = ClientRegionShortcut.LOCAL //Disable Client Server Mode
)
@EnableGemFireHttpSession(
		regionName = "SpringSession",
		poolName = ClientRegionFactoryBean.DEFAULT_POOL_NAME, 
		maxInactiveIntervalInSeconds = 60, 
		clientRegionShortcut = ClientRegionShortcut.LOCAL //Disable Client Server Mode
)
@EnableGemfireRepositories(basePackages = {"com.spring.session.repositories"})
class AppSessionConfig {

    Logger log = LoggerFactory.getLogger(getClass());
    
}