package org.example.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "vo_borrow")
public class BorrowVo implements Serializable {
    @Id
    private Integer borrowId;
    private String bname;
    @JsonIgnore
    private String uname;
    // 借阅时间
    @Column(name = "b_date")
    private String borrowDate;
    // 归还时间
    @Column(name = "r_date")
    private String returnDate;
    // 借阅状态:[0-未归还][1-已归还]
    private Integer state;
}

