package yeeCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yeeCommerce.entity.Product;
import yeeCommerce.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查詢商品
    @GetMapping("/api/products")
    public Page<Product> getProducts(
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
    	// 創建 PageRequest 對象，並設置頁碼和每頁條數
        Pageable pageable = PageRequest.of(page, size); // 創建 PageRequest 對象，並設置頁碼和每頁條數
        // 調用 ProductService 進行查詢，並返回對應的結果
        return productService.getProducts(categoryName, storeName, minPrice, maxPrice, pageable);
    }
}
