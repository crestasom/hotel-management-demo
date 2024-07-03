package com.cretasom.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cretasom.hotel.entity.Hotel;
import com.cretasom.hotel.entity.Rating;
import com.cretasom.hotel.entity.RatingDTO;
import com.cretasom.hotel.entity.User;

@Service
public class RatingServiceImpl {

	List<Rating> ratingList = new ArrayList<>();
	int i = 1;

	@Autowired
	private HotelServiceImpl hotelImpl;
	@Autowired
	private UserServiceImpl userImpl;

	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		rating.setId(i);
		i++;
		ratingList.add(rating);
		return rating;
	}

	public Rating getRating(int id) {
		// id 1,2,4
		for (Rating u : ratingList) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public List<RatingDTO> getAllRating() {
		List<RatingDTO> ratingDtoList = new ArrayList<>();
		for (Rating r : ratingList) {
			RatingDTO rd = new RatingDTO();
			rd.setComment(r.getComment());
			rd.setRating(r.getRating());
			Hotel h = hotelImpl.getHotel(r.getHotelId());
			rd.setHotelName(h.getName());
			User u = userImpl.getUser(r.getUserId());
			rd.setUserName(u.getName());
			ratingDtoList.add(rd);
		}
		return ratingDtoList;
	}

}
