package org.example.repository;

import org.example.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO `db_storage` (storage_id,uid,bid,count) VALUES (0,:uid,:bid,:count)")
    Integer addStorageRecord(@Param("uid")String uid,@Param("bid") String bid,@Param("count") Integer count);
}
