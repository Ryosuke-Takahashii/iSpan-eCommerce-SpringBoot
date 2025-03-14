package yeeCommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Integer shopId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 與 User 表的關聯（用戶即賣家）

    @Column(name = "store_name", nullable = false, length = 1000)
    private String storeName;

    @Column(name = "store_description", length = 1000)
    private String storeDescription;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Lob
    @Column(name = "seller_photo")
    private byte[] sellerPhoto;

    @Column(name = "seller_status", nullable = false)
    private Byte sellerStatus;

    @Column(name = "shop_status", nullable = false)
    private Boolean shopStatus;  // 布林值表示商店狀態
}
