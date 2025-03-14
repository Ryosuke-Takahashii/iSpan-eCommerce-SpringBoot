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

    // 根據產品描述中的關鍵字查詢（使用 LIKE），並支持分頁
    Page<Product> findByProductDescriptionContaining(String keyword, Pageable pageable);
    
 // 根據 categoryName 查詢商品，並支持分頁
    @Query("SELECT p FROM Product p JOIN p.productCategory c WHERE c.categoryName LIKE %:categoryName%")
    Page<Product> findByCategoryNameContaining(@Param("categoryName") String categoryName, Pageable pageable);

    // 根據 storeName 查詢商品，並支持分頁
    @Query("SELECT p FROM Product p JOIN p.shop s WHERE s.storeName LIKE %:storeName%")
    Page<Product> findByStoreNameContaining(@Param("storeName") String storeName, Pageable pageable);

    // 根據 categoryName 和價格範圍查詢商品，並支持分頁
    @Query("SELECT p FROM Product p JOIN p.productCategory c JOIN p.shop s WHERE c.categoryName LIKE %:categoryName% " +
            "AND p.productPrice BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByCategoryNameAndPriceBetween(@Param("categoryName") String categoryName,
                                                    @Param("minPrice") Integer minPrice,
                                                    @Param("maxPrice") Integer maxPrice, Pageable pageable);

    // 根據 productName 進行模糊查詢，並支持分頁
    Page<Product> findByProductNameContaining(String productName, Pageable pageable);

    // 根據名稱、描述、狀態進行模糊查詢，並支持分頁
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name% AND p.productDescription LIKE %:desc%")
    Page<Product> searchProductsByNameAndDescriptionAndStatus(@Param("name") String name,
            @Param("desc") String description, Pageable pageable);
}
