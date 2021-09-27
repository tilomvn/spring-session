package com.spring.session.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region
public class ResponseModel {
	
	@Id
	String id;
	
    String value;
    
    public ResponseModel(String value) { this.id = value; this.value = "value-" + value; }
    
    public String getValue() { return value; }

	public String getId() { return id; }
}