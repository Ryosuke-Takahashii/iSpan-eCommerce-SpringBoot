package yeeCommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import yeeCommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 根據產品名稱查詢，並支持分頁
    Page<Product> findByProductName(String productName, Pageable pageable);

    // 根據產品類別查詢，並支持分頁
    Page<Product> findByProductCategory_CategoryId(Integer categoryId, Pageable pageable);

    // 根據價格範圍查詢，並支持分頁
    Page<Product> findByProductPriceBetween(Integer minPrice, Integer maxPrice, Pageable pageable);

    // 根據名稱和價格範圍查詢，並支持分頁
    Page<Product> findByProductNameAndProductPriceBetween(String productName, Integer minPrice, Integer maxPrice, Pageable pageable);

    // 根據賣家ID和類別ID查詢，並支持分頁
    Page<Product> findBySeller_MemberIdAndProductCategory(Integer sellerId, Integer categoryId, Pageable pageable);

    // 根據賣家ID和產品庫存查詢，並支持分頁
    Page<Product> findBySeller_MemberIdAndProductStockGreaterThan(Integer sellerId, Integer stock, Pageable pageable);

    // 根據產品描述中的關鍵字查詢（使用 LIKE），並支持分頁
    Page<Product> findByProductDescriptionContaining(String keyword, Pageable pageable);

    // 根據賣家ID和產品價格範圍查詢，並支持分頁
    Page<Product> findBySeller_MemberIdAndProductPriceBetween(Integer sellerId, Integer minPrice, Integer maxPrice, Pageable pageable);

    // 根據名稱、描述、狀態進行模糊查詢，並支持分頁
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name% AND p.productDescription LIKE %:desc%")
    Page<Product> searchProductsByNameAndDescriptionAndStatus(@Param("name") String name,
            @Param("desc") String description, Pageable pageable);
}
