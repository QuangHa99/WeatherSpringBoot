package com.quangha.weather.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quangha.weather.entity.*;
import com.quangha.weather.service.WeatherService;

@RestController
public class RestDatatables {
	@Autowired
    private WeatherService weatherService;
	@GetMapping("/data-bookmark")
	public ResponseEntity<Datatables> getDataBookmarked(){
		List<List<String>> datatables = new ArrayList<List<String>>();
		Iterable<Weather> weathers = this.weatherService.getAllThoiTiet();
		for (Weather weather : weathers) {
			List<String> array = new ArrayList<String>();
			array.add(weather.getId().toString());
			array.add(weather.getDiaDiem());
			array.add(weather.getThoiGian());
			array.add(weather.getNhietDo());
			array.add(weather.getTocDoGio());
			array.add(weather.getMay());
			array.add(weather.getApSuat());
			array.add(weather.getDoAm());
			array.add(weather.getToaDo());
			datatables.add(array);
		}
		Datatables responseObj = new Datatables();
		responseObj.setData(datatables);
		return new ResponseEntity<Datatables>(responseObj,HttpStatus.OK);
	}
	@PostMapping("/insert-bookmark")
	public String insertData(@RequestParam("diadiem") String diaDiem,
			@RequestParam("nhietdo") String nhietDo,
			@RequestParam("tocdogio") String tocDoGio, @RequestParam("may") String May, @RequestParam("apsuat") String apSuat,
			@RequestParam("toado") String toaDo, @RequestParam("doam") String doAm) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Weather b = new Weather();
		//b.setId(id);
		b.setDiaDiem(diaDiem);
		b.setThoiGian(formatter.format(date));
		b.setNhietDo(nhietDo);
		b.setTocDoGio(tocDoGio);
		b.setMay(May);
		b.setApSuat(apSuat);
		b.setDoAm(doAm);
		b.setToaDo(toaDo);
		this.weatherService.saveThoiTiet(b);
		return "Lưu thời tiết thành công!";
	}
	@PostMapping("/delete-bookmark")
	public String deleteData(@RequestParam("id") String id) {
		this.weatherService.deleteWeather(Long.valueOf(id.trim()));
		return "Xóa thành công!";
	}
}
