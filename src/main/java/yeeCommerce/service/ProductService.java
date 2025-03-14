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
    private final ProductRepository productRepository;
    
	
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 根據產品名稱查詢，並支持分頁
    public Page<Product> getProductsByName(String productName, Pageable pageable) {
        return productRepository.findByProductName(productName, pageable);
    }

    // 根據產品類別查詢，並支持分頁
    public Page<Product> getProductsByCategoryId(Integer categoryId, Pageable pageable) {
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

    // 根據產品描述中的關鍵字查詢，並支持分頁
    public Page<Product> getProductsByDescriptionKeyword(String keyword, Pageable pageable) {
        return productRepository.findByProductDescriptionContaining(keyword, pageable);
    }

    // 根據 categoryName 查詢商品，並支持分頁
    public Page<Product> getProductsByCategoryName(String categoryName, Pageable pageable) {
        return productRepository.findByCategoryNameContaining(categoryName, pageable);
    }

    // 根據 storeName 查詢商品，並支持分頁
    public Page<Product> getProductsByStoreName(String storeName, Pageable pageable) {
        return productRepository.findByStoreNameContaining(storeName, pageable);
    }

    // 根據 categoryName 和價格範圍查詢商品，並支持分頁
    public Page<Product> getProductsByCategoryNameAndPriceRange(String categoryName, Integer minPrice, Integer maxPrice, Pageable pageable) {
        return productRepository.findByCategoryNameAndPriceBetween(categoryName, minPrice, maxPrice, pageable);
    }

    // 根據 productName 進行模糊查詢，並支持分頁
    public Page<Product> getProductsByNameContaining(String productName, Pageable pageable) {
        return productRepository.findByProductNameContaining(productName, pageable);
    }

    // 根據名稱、描述、狀態進行模糊查詢，並支持分頁
    public Page<Product> searchProductsByNameAndDescriptionAndStatus(String name, String description, Pageable pageable) {
        return productRepository.searchProductsByNameAndDescriptionAndStatus(name, description, pageable);
    }
    
    public Page<Product> getProducts(String categoryName, String storeName, Integer minPrice, Integer maxPrice, Pageable pageable) {
        // 根據前端傳來的查詢條件進行處理
        if (categoryName != null && storeName != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryNameAndPriceBetween(categoryName, minPrice, maxPrice, pageable);
        } else if (categoryName != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryNameAndPriceBetween(categoryName, minPrice, maxPrice, pageable);
        } else if (categoryName != null) {
            return productRepository.findByCategoryNameContaining(categoryName, pageable);
        } else if (storeName != null) {
            return productRepository.findByStoreNameContaining(storeName, pageable);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByProductPriceBetween(minPrice, maxPrice, pageable);
        } else {
            return productRepository.findAll(pageable); // 如果沒傳遞任何查詢條件，返回所有商品
        }
    }
}
