package yeeCommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "product_description", length = 2000)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", nullable = false)
    private Category productCategory;  // 與 Category 表的關聯

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_shop_id", nullable = false)
    private Shop shop;  // 與 Shop 表的關聯

    @Lob
    @Column(name = "product_photo")
    private byte[] productPhoto;

    @Column(name = "product_status")
    private Integer productStatus;
}
