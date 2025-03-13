package yeeCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yeeCommerce.entity.Product;
import yeeCommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 根據產品名稱查詢，並支持分頁
    @GetMapping("/search/by-name")
    public Page<Product> getProductsByName(@RequestParam String productName, Pageable pageable) {
        return productService.getProductsByName(productName, pageable);
    }

    // 根據產品類別查詢，並支持分頁
    @GetMapping("/search/by-category/{categoryId}")
    public Page<Product> getProductsByCategory(@PathVariable Integer categoryId, Pageable pageable) {
        return productService.getProductsByCategory(categoryId, pageable);
    }

    // 根據價格範圍查詢，並支持分頁
    @GetMapping("/search/by-price-range")
    public Page<Product> getProductsByPriceRange(@RequestParam Integer minPrice, @RequestParam Integer maxPrice, Pageable pageable) {
        return productService.getProductsByPriceRange(minPrice, maxPrice, pageable);
    }

    // 根據名稱和價格範圍查詢，並支持分頁
    @GetMapping("/search/by-name-and-price")
    public Page<Product> getProductsByNameAndPriceRange(@RequestParam String productName, @RequestParam Integer minPrice, @RequestParam Integer maxPrice, Pageable pageable) {
        return productService.getProductsByNameAndPriceRange(productName, minPrice, maxPrice, pageable);
    }

    // 根據賣家ID和類別ID查詢，並支持分頁
    @GetMapping("/search/by-seller-and-category")
    public Page<Product> getProductsBySellerAndCategory(@RequestParam Integer sellerId, @RequestParam Integer categoryId, Pageable pageable) {
        return productService.getProductsBySellerAndCategory(sellerId, categoryId, pageable);
    }

    // 根據賣家ID和產品庫存查詢，並支持分頁
    @GetMapping("/search/by-seller-and-stock")
    public Page<Product> getProductsBySellerAndStock(@RequestParam Integer sellerId, @RequestParam Integer stock, Pageable pageable) {
        return productService.getProductsBySellerAndStock(sellerId, stock, pageable);
    }

    // 根據產品描述中的關鍵字查詢，並支持分頁
    @GetMapping("/search/by-description")
    public Page<Product> getProductsByDescription(@RequestParam String keyword, Pageable pageable) {
        return productService.getProductsByDescription(keyword, pageable);
    }

    // 根據賣家ID和價格範圍查詢，並支持分頁
    @GetMapping("/search/by-seller-and-price")
    public Page<Product> getProductsBySellerAndPriceRange(@RequestParam Integer sellerId, @RequestParam Integer minPrice, @RequestParam Integer maxPrice, Pageable pageable) {
        return productService.getProductsBySellerAndPriceRange(sellerId, minPrice, maxPrice, pageable);
    }

    // 根據名稱、描述、狀態進行模糊查詢，並支持分頁
    @GetMapping("/search")
    public Page<Product> searchProducts(@RequestParam String name, @RequestParam String description, Pageable pageable) {
        return productService.searchProducts(name, description, pageable);
    }
}
