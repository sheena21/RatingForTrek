package com.hiker.Ratings.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiker.Ratings.entity.Rating;
import com.hiker.Ratings.repository.RatingRepo;

@Service
public class RatingService {

	@Autowired
	private RatingRepo ratingRepo;

	public Rating saveRating( Rating rating) {
		
		return ratingRepo.save(rating);
	}

	public List<Rating> getAll() {
		
		return ratingRepo.findAll();
	}

	public Rating getById(Integer id) {
		return ratingRepo.findById(id).get();
	}

	public Rating update(Integer id, Rating rating) {
		ratingRepo.findById(id);
		
		return ratingRepo.save(rating);
	}

	public Rating delete(Integer id) {
		ratingRepo.deleteById(id);
		return null;
	}
	
}
