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
    private String uname;
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

