package com.api.weather.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.api.weather.entity.WeatherEntity;




@Repository
public class WeatherRepository  {
	
	@Autowired 
	private DynamoDBMapper mapper;
	
	 public WeatherEntity save(WeatherEntity weather) {
	        mapper.save(weather);
	        return weather;
	    }
	 
	 public WeatherEntity findWeatherByZipCode(Integer zipcode) {
	        return mapper.load(WeatherEntity.class, zipcode);
	    }
	 
	  private DynamoDBSaveExpression buildExpression(WeatherEntity weather) {
	        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
	        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
	        expectedMap.put("zipcode", new ExpectedAttributeValue(new AttributeValue().withS(weather.getZipcode().toString())));
	        dynamoDBSaveExpression.setExpected(expectedMap);
	        return dynamoDBSaveExpression;
	    }
}
