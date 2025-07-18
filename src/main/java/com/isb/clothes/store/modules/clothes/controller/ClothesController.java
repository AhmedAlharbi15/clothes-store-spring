package com.isb.clothes.store.modules.clothes.controller;


import com.isb.clothes.store.modules.clothes.dto.ClothesDto;
import com.isb.clothes.store.modules.clothes.dto.RatingDto;
import com.isb.clothes.store.modules.clothes.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("clothes")
@RequiredArgsConstructor
public class ClothesController {
    private final ClothesService clothesService;
    @PostMapping("")
    public List<ClothesDto> saveClothes(@RequestBody List<ClothesDto> clothesDtoList){
        return clothesService.save(clothesDtoList);
    }

    @GetMapping("")
    public List<ClothesDto> getAllClothes(){
        return clothesService.getAllClothes();
    }

}
