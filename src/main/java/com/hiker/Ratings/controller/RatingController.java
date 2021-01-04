package com.hiker.Ratings.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiker.Ratings.entity.Rating;
import com.hiker.Ratings.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRating(@Valid @RequestBody Rating rating){
		Rating savedRating=ratingService.saveRating(rating);
		return new ResponseEntity<>(savedRating,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	private ResponseEntity<?> getAll()
	{
		List<Rating> getAll=ratingService.getAll();
		return new ResponseEntity<>(getAll,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable Integer id)
	{
		Rating getByIdRating=ratingService.getById(id);
		return new ResponseEntity<>(getByIdRating,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	private ResponseEntity<?> update(@Valid @PathVariable Integer id, @Valid @RequestBody Rating rating){
		Rating updatedRating=ratingService.update(id,rating);
		return new ResponseEntity<>(updatedRating,HttpStatus.ACCEPTED);
	}
    
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<?> delete(@Valid @PathVariable Integer id)
	{
		Rating deleteRating=ratingService.delete(id);
		return new ResponseEntity<>(deleteRating,HttpStatus.OK);
	}
}
