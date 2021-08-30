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
    @Query(value = "select * from tuple where tuple.fixed_id=?1", nativeQuery = true)
    TupleEntity[] getByFixedId(Integer fixid);
    // new
    @Nullable
    @Query(value = "select * from tuple where tuple.mutationLocation=?1", nativeQuery = true)
    TupleEntity[] getByMutationLocation(String fixid);

    @Nullable
    @Query(value = "select * from tuple where tuple.ill_type like ?1", nativeQuery = true)
    TupleEntity[] getByIllType(String fixid);

    @Nullable
    @Query(value = "select * from tuple where tuple.mutation_type like ?1", nativeQuery = true)
    TupleEntity[] getByMutationType(String type);

    @Nullable
    @Query(value = "select * from tuple where tuple.amino_acid like ?1", nativeQuery = true)
    TupleEntity[] getByAminoAcid(String type);

    @Nullable
    @Query(value = "select * from tuple where tuple.nucleotide like ?1", nativeQuery = true)
    TupleEntity[] getByNucleotide(String type);
}
