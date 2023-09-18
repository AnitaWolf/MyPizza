package com.example.mypizza.service.util;

import com.example.mypizza.dto.CafeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CafeService {

    List<CafeDto> getCafeList();

    CafeDto getCafeById(String id);

    CafeDto addCafe(CafeDto cafeDto);

    void deleteCafeById(String id);

    CafeDto updateCafe(CafeDto cafeDto, String id);
}
