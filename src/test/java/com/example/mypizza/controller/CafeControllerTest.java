package com.example.mypizza.controller;

import com.example.mypizza.dto.CafeDto;
import com.example.mypizza.service.util.CafeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CafeControllerTest {

    @Mock
    private CafeService cafeService;

    @InjectMocks
    private CafeController cafeController;

    public CafeControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCafes() {
        List<CafeDto> cafes = new ArrayList<>();
        when(cafeService.getCafeList()).thenReturn(cafes);

        List<CafeDto> result = cafeController.getAllCafes();

        assertEquals(cafes, result);
    }

    @Test
    void testGetCafeById() {
        String cafeId = "cafeId";
        CafeDto cafe = new CafeDto();
        when(cafeService.getCafeById(cafeId)).thenReturn(cafe);

        CafeDto result = cafeController.getCafeById(cafeId);

        assertEquals(cafe, result);
    }

    @Test
    void testCreateCafe() {
        CafeDto cafeDto = new CafeDto();
        when(cafeService.addCafe(cafeDto)).thenReturn(cafeDto);

        CafeDto result = cafeController.createCafe(cafeDto);

        assertEquals(cafeDto, result);
    }

    @Test
    void testDeleteCafe() {
        String cafeId = "cafeId";
        doNothing().when(cafeService).deleteCafeById(cafeId);

        cafeController.deleteCafe(cafeId);
        verify(cafeService, times(1)).deleteCafeById(cafeId);
    }

    @Test
    void testUpdateCafe() {
        String cafeId = "cafeId";
        CafeDto cafeDto = new CafeDto();
        when(cafeService.updateCafe(cafeDto, cafeId)).thenReturn(cafeDto);

        CafeDto result = cafeController.updateCafe(cafeId, cafeDto);

        assertEquals(cafeDto, result);
    }

}