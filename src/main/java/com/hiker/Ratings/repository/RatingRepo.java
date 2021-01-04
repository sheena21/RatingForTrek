package com.hiker.Ratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiker.Ratings.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer> {

}
