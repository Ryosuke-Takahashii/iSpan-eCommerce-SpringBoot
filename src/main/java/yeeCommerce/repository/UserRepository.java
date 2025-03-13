package yeeCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeeCommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
