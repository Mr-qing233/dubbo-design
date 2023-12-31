package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,String > {
    // 用户登录验证
    // 用户注册-新增用户数据
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO `db_user` (uid,password,uname,birthday,phone,email,privilege) VALUES " +
            "(:#{#user.uid},:#{#user.password},:#{#user.uname},:#{#user.birthday},:#{#user.phone},:#{#user.email},0);")
    Integer newUser(@Param("user")User user);

    // 校验用户名是否存在
    User findUserByUname(String uname);
}
