package com.example.mypizza.controller;


import com.example.mypizza.model.Cafe;
import com.example.mypizza.service.util.CafeService;
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
        List<Cafe> cafes = new ArrayList<>();
        when(cafeService.getCafeList()).thenReturn(cafes);

        List<Cafe> result = cafeController.getAllCafes();

        assertEquals(cafes, result);
    }

    @Test
    void testGetCafeById() {
        String cafeId = "cafeId";
        Cafe cafe = new Cafe();
        when(cafeService.getCafeById(cafeId)).thenReturn(cafe);

        Cafe result = cafeController.getCafeById(cafeId);

        assertEquals(cafe, result);
    }

    @Test
    void testCreateCafe() {
        Cafe cafe = new Cafe();
        when(cafeService.addCafe(cafe)).thenReturn(cafe);

        Cafe result = cafeController.createCafe(cafe);

        assertEquals(cafe, result);
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
        Cafe cafe = new Cafe();
        when(cafeService.updateCafe(cafe, cafeId)).thenReturn(cafe);

        Cafe result = cafeController.updateCafe(cafeId, cafe);

        assertEquals(cafe, result);
    }

}