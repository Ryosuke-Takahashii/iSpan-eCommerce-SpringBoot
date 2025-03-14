package yeeCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import yeeCommerce.entity.Product;
import yeeCommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 根據產品名稱查詢，並支持分頁
    public Page<Product> getProductsByName(String productName, Pageable pageable) {
        return productRepository.findByProductName(productName, pageable);
    }

    // 根據產品類別查詢，並支持分頁
    public Page<Product> getProductsByCategory(Integer categoryId, Pageable pageable) {
        return productRepository.findByProductCategory_CategoryId(categoryId, pageable);
    }

    // 根據價格範圍查詢，並支持分頁
    public Page<Product> getProductsByPriceRange(Integer minPrice, Integer maxPrice, Pageable pageable) {
        return productRepository.findByProductPriceBetween(minPrice, maxPrice, pageable);
    }

    // 根據名稱和價格範圍查詢，並支持分頁
    public Page<Product> getProductsByNameAndPriceRange(String productName, Integer minPrice, Integer maxPrice, Pageable pageable) {
        return productRepository.findByProductNameAndProductPriceBetween(productName, minPrice, maxPrice, pageable);
    }

    // 根據賣家ID和類別ID查詢，並支持分頁
    public Page<Product> getProductsBySellerAndCategory(Integer sellerId, Integer categoryId, Pageable pageable) {
        return productRepository.findBySeller_MemberIdAndProductCategory(sellerId, categoryId, pageable);
    }

    // 根據賣家ID和產品庫存查詢，並支持分頁
    public Page<Product> getProductsBySellerAndStock(Integer sellerId, Integer stock, Pageable pageable) {
        return productRepository.findBySeller_MemberIdAndProductStockGreaterThan(sellerId, stock, pageable);
    }

    // 根據描述中的關鍵字查詢，並支持分頁
    public Page<Product> getProductsByDescription(String keyword, Pageable pageable) {
        return productRepository.findByProductDescriptionContaining(keyword, pageable);
    }

    // 根據賣家ID和價格範圍查詢，並支持分頁
    public Page<Product> getProductsBySellerAndPriceRange(Integer sellerId, Integer minPrice, Integer maxPrice, Pageable pageable) {
        return productRepository.findBySeller_MemberIdAndProductPriceBetween(sellerId, minPrice, maxPrice, pageable);
    }

    // 根據名稱、描述、狀態進行模糊查詢，並支持分頁
    public Page<Product> searchProducts(String name, String description, Pageable pageable) {
        return productRepository.searchProductsByNameAndDescriptionAndStatus(name, description, pageable);
    }
    
    //abcdefg
}
