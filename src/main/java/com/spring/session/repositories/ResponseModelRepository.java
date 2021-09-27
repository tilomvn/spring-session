package com.spring.session.repositories;

import org.springframework.data.gemfire.repository.GemfireRepository;

import com.spring.session.entities.ResponseModel;

public interface ResponseModelRepository extends GemfireRepository<ResponseModel, String> {

}
