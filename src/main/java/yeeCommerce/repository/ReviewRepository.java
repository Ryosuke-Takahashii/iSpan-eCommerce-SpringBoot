package yeeCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeeCommerce.entity.Review;




@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
