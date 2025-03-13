package yeeCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yeeCommerce.entity.Review;
import yeeCommerce.service.ReviewService;


@RestController
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/allreviews")
    public List<Review> getReviews() {
        // 返回所有 manager 的資料，以 JSON 格式
        return reviewService.getAllReviews();
    }
}