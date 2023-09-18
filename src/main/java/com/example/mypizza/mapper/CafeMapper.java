package com.example.mypizza.mapper;

import com.example.mypizza.dto.CafeDto;
import com.example.mypizza.model.Cafe;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CafeMapper {
    CafeDto toDTO(Cafe cafe);
    Cafe toEntity(CafeDto cafeDto);
}

