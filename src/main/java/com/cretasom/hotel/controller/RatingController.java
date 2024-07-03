package com.cretasom.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cretasom.hotel.entity.Rating;
import com.cretasom.hotel.entity.RatingDTO;
import com.cretasom.hotel.service.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {

	public RatingController() {
		System.out.println("Creating bean of User controller");
	}

	@Autowired
	private RatingServiceImpl ratingService;

	@PostMapping("/")
	public Rating addRating(@RequestBody Rating rating) {
		System.out.println(rating);
		return ratingService.addRating(rating);
	}

	@GetMapping("/get-all")
	public List<RatingDTO> getAllRating() {
		return ratingService.getAllRating();
	}
}
