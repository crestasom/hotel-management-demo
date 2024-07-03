package com.cretasom.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cretasom.hotel.entity.Hotel;
import com.cretasom.hotel.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	public HotelController() {
		System.out.println("Creating bean of User controller");
	}

	@Autowired
	private HotelServiceImpl hotelService;

	@PostMapping("/")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		System.out.println(hotel);
		return hotelService.addHotel(hotel);
	}

	@GetMapping("/get-all")
	public List<Hotel> getAllHotel() {
		return hotelService.getAllHotel();
	}
}
