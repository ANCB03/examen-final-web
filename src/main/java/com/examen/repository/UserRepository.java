package com.examen.repository;

import com.examen.entity.Bill;
import com.examen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(
            value = "SELECT * from users u where u.username = :user",
            nativeQuery = true
    )
    User findMovimientos(@Param("user") String user);


}
