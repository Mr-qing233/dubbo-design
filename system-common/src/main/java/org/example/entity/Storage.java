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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_storage")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Storage implements Serializable {
    @Id
    @Column(name = "storage_id")
    private Integer storageId;
    private String uid;
    private String bid;
    private Integer count;

}
