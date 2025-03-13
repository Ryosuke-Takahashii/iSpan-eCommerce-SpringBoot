package yeeCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yeeCommerce.entity.Shop;
import yeeCommerce.service.ShopService;



@RestController
public class ShopsRestController {

	@Autowired
	private ShopService shopService;
	
	@GetMapping("/allshops")
    public List<Shop> getShops() {
        // 返回所有 manager 的資料，以 JSON 格式
        return shopService.getAllShops();
    }
}