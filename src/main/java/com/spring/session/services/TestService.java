package com.spring.session.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.session.entities.ResponseModel;
import com.spring.session.repositories.ResponseModelRepository;

@Service
@CacheConfig(cacheNames = "ResponseModel", cacheManager = "gemFireCacheManager")
public class TestService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	final ResponseModelRepository responseModelRepository;
	
	TestService(ResponseModelRepository responseModelRepository) {
		this.responseModelRepository = responseModelRepository;
	}
	
	@Cacheable
	public ResponseModel get(String id) {
		log.info("Not in cache...");
		ResponseModel model = new ResponseModel(id);
		new Thread(() -> {
			try {
				Thread.sleep(10000);
				responseModelRepository.findAll().iterator().forEachRemaining(d -> {
					log.info(d.getId());
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		return model;
	}
}
