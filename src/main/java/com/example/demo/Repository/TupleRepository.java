package com.example.demo.Repository;

import com.example.demo.Entity.TupleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TupleRepository extends JpaRepository<TupleEntity, Integer> {
    @Nullable
    @Query(value = "select * from tuple",nativeQuery = true)
    TupleEntity[] getAllData();

    @Nullable
    @Query(value = "select * from tuple where userId = ?1", nativeQuery = true)
    TupleEntity[] getAllByUserId(Integer userId);

    @Nullable
    @Query(value = "select * from tuple where tuple.fixedId=?1", nativeQuery = true)
    TupleEntity[] getByFixedId(Integer fixid);
}
