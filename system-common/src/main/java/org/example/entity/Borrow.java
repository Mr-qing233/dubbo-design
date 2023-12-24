package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 借阅实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_borrow")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Borrow implements Serializable {

    @Id
    @Column(name = "borrow_id")
    private Integer borrowId;
    // 书籍id
    private String bid;
    // 用户id
    private String uid;
    // 借阅时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "b_date")
    private String bDate;
    // 归还时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "r_date")
    private String rDate;
    // 借阅状态:[0-未归还][1-已归还]
    private Integer state;
}
