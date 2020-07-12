package com.quangha.weather.service;

import com.quangha.weather.entity.Weather;
import java.util.List;  

public interface WeatherService {
	public void saveThoiTiet(Weather thoitiet);  
	List<Weather> getAllThoiTiet();  
	public void deleteWeather(Long id);  
}
