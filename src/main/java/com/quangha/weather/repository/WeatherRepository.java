package com.quangha.weather.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quangha.weather.entity.*;

@Repository  
public interface WeatherRepository extends CrudRepository<Weather, Long>{

}
