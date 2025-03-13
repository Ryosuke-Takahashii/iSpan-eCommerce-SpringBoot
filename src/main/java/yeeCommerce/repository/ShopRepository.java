package yeeCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeeCommerce.entity.Shop;



@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
