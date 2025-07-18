package com.isb.clothes.store.modules.clothes.service;

import com.isb.clothes.store.modules.clothes.dto.ClothesDto;
import com.isb.clothes.store.modules.clothes.entity.ClothesEntity;
import com.isb.clothes.store.modules.clothes.mapper.ClothesMapper;
import com.isb.clothes.store.modules.clothes.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;
    private final ClothesMapper clothesMapper;

    public ClothesEntity saveClothe(ClothesDto clothesDto){
        return clothesRepository.save(clothesMapper.toEntity(clothesDto));
    }

    public List<ClothesDto> save(List<ClothesDto> clothesDtoList){
        return clothesMapper.toDtoList( clothesRepository.saveAll(clothesMapper.toEntityList(clothesDtoList)));
    }

    public ClothesDto getClothe(int id){
        Optional<ClothesEntity> clothesEntity =clothesRepository.findById(id);
        return clothesMapper.toDto(clothesEntity.get());
    }

    public List<ClothesDto> getAllClothes(){
        List<ClothesEntity> clothesEntityList = clothesRepository.findAll();
        return clothesMapper.toDtoList(clothesEntityList);
    }
}
