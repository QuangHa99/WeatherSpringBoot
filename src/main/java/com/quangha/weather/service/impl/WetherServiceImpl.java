package com.quangha.weather.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quangha.weather.entity.Weather;
import com.quangha.weather.repository.WeatherRepository;
import com.quangha.weather.service.WeatherService;

@Service
public class WetherServiceImpl implements WeatherService{
	@Autowired private WeatherRepository thoitietRepository;

	@Override
	public void saveThoiTiet(Weather thoitiet) {
		thoitietRepository.save(thoitiet);
		
	}

	@Override
	public List<Weather> getAllThoiTiet() {
		return (List<Weather>) thoitietRepository.findAll();  
	}
	@Override
	public void deleteWeather(Long id) {
		thoitietRepository.deleteById(id);  
	}

}
