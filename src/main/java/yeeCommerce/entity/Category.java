package yeeCommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")  // 可選，指定表名（如果表名不是類名的話）
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private Integer categoryId;    // category_id 為主鍵
    private String categoryName;    // category_name
    private Integer parentId;      // parent_id

}
