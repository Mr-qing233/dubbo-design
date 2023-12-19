package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 书籍实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Book implements Serializable {
    // 书籍id
    @Id
    private String bid;
    // 书籍名称
    @Column(name = "bname")
    private String bName;
    // 作者
    private String author;
    // 分类
    private String category;
    // 出版社
    private String publish;
    // 位置[书架字母编号]-[位置数字编号]
    private String location;
    // 总数
    @Column(name = "total_quantity")
    private Integer totalQuantity;
    // 库存数
    @Column(name = "stock_quantity")
    private Integer stockQuantity;

}
