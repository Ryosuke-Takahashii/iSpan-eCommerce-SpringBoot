package yeeCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeeCommerce.entity.Shop;
import yeeCommerce.repository.ShopRepository;

@Service
public class ShopService {
	@Autowired
	private ShopRepository shopRepository;

	public List<Shop> getAllShops() {
		return shopRepository.findAll();
	}
}