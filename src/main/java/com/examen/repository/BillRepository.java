package com.examen.repository;

import com.examen.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Integer> {

    @Query(
            value = "SELECT * from bill u where u.user_id = (SELECT id from users s where s.username=:user)",
            nativeQuery = true
    )
    List<Bill> findMovimientos(@Param("user") String user);
}
