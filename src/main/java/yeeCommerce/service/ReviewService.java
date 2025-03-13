package yeeCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeeCommerce.entity.Review;
import yeeCommerce.repository.ReviewRepository;



@Service
public class ReviewService {
@Autowired
private ReviewRepository reviewRepository;

public List<Review> getAllReviews() {
    return reviewRepository.findAll();
}
}