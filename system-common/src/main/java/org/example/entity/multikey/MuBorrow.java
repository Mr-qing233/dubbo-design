package org.example.entity.multikey;

import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 多主键配置
 */

@Data
public class MuBorrow implements Serializable {
    @Serial
    private static final long serialVersionUID = -1570834456846579284L;
    /**
     * 书籍id
     */
    private String bid;
    /**
     * 用户id
     */
    private String uid;
}
