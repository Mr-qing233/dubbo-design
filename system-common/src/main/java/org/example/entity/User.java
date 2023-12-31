package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User implements Serializable {
    @Id
    private String uid;
    private String uname;
    private String password;
    private String birthday;
    private String phone;
    private String email;
    private Integer privilege;
}
