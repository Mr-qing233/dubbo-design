package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.multikey.MuBorrow;

import java.io.Serializable;
import java.util.Date;

/**
 * 借阅实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(MuBorrow.class)
@Table(name = "db_borrow")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Borrow implements Serializable {
    // 书籍id
    @Id
    private String bid;
    // 用户id
    @Id
    private String uid;
    // 借阅时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    @Column(name = "bdate")
    private Date bDate;
    // 归还时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    @Column(name = "rdate")
    private Date rDate;
    // 借阅状态:[0-未归还][1-已归还]
    private Integer state;
}
