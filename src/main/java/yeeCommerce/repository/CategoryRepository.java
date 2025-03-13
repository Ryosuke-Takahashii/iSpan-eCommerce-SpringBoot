package yeeCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeeCommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
