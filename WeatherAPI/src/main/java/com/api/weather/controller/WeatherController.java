package com.api.weather.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.weather.constant.WeatherConstant;
import com.api.weather.entity.WeatherEntity;
import com.api.weather.model.RequestModel;
import com.api.weather.model.WeatherModel;
import com.api.weather.repository.WeatherRepository;

@RestController
@RequestMapping(value = WeatherConstant.API_URL, produces = "application/json")
public class WeatherController {

	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private WeatherRepository repository;
	

	@PostMapping(WeatherConstant.API_WEATHER_INSERT)
	public String insertDetails(@RequestBody RequestModel model) {
		Integer zip=model.getZipcode();
		String country=model.getCountry();
		WeatherModel response = resttemplate.getForObject(
				"http://api.openweathermap.org/data/2.5/weather?zip="+zip+","+country+"&appid=9de243494c0b295cca9337e1e96b00e2",
				WeatherModel.class);
		WeatherEntity entity=new WeatherEntity();
		entity.setDate(new Date());
		entity.setTemp(response.getMain().getTemp());
		entity.setZipcode(model.getZipcode());
		repository.save(entity);
		return "Temparature Information for zipcode " +zip+" is saved successfully";
	}
	
	@GetMapping(WeatherConstant.API_WEATHER_DETAILS)
	public WeatherEntity getWeatherDetails(@RequestParam("zipcode")Integer zipcode) {
		
		return repository.findWeatherByZipCode(zipcode);
		
	}

}
