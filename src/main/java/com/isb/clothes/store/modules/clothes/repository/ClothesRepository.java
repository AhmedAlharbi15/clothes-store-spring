package com.isb.clothes.store.modules.clothes.repository;

import com.isb.clothes.store.modules.clothes.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<ClothesEntity, Integer> {
}
