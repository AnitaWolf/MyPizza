package com.example.mypizza.controller;

import com.example.mypizza.dto.PizzaDto;
import com.example.mypizza.service.util.PizzaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PizzaControllerTest {

    @Mock
    private PizzaService pizzaService;

    @InjectMocks
    private PizzaController pizzaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPizzas() {
        // Arrange
        List<PizzaDto> pizzas = new ArrayList<>();
        when(pizzaService.getPizzaList()).thenReturn(pizzas);

        // Act
        List<PizzaDto> result = pizzaController.getAllPizzas();

        // Assert
        assertEquals(pizzas, result);
        verify(pizzaService, times(1)).getPizzaList();
    }

    @Test
    void testGetPizzasByName() {
        // Arrange
        String pizzaName = "Margherita";
        PizzaDto pizzaDto = new PizzaDto();
        when(pizzaService.getPizzaByName(pizzaName)).thenReturn(pizzaDto);

        // Act
        PizzaDto result = pizzaController.getPizzasByName(pizzaName);

        // Assert
        assertEquals(pizzaDto, result);
        verify(pizzaService, times(1)).getPizzaByName(pizzaName);
    }

    @Test
    void testCreatePizza() {
        // Arrange
        PizzaDto pizzaDto = new PizzaDto();
        when(pizzaService.addPizza(pizzaDto)).thenReturn(pizzaDto);

        // Act
        PizzaDto result = pizzaController.createPizza(pizzaDto);

        // Assert
        assertEquals(pizzaDto, result);
        verify(pizzaService, times(1)).addPizza(pizzaDto);
    }

    @Test
    void testDeletePizza() {
        // Arrange
        String pizzaId = "123";
        doNothing().when(pizzaService).deletePizzaById(pizzaId);

        // Act
        pizzaController.deletePizza(pizzaId);

        // Assert
        verify(pizzaService, times(1)).deletePizzaById(pizzaId);
    }

    @Test
    void testUpdatePizza() {
        // Arrange
        String pizzaId = "123";
        PizzaDto pizzaDto = new PizzaDto();
        when(pizzaService.updatePizza(pizzaDto, pizzaId)).thenReturn(pizzaDto);

        // Act
        PizzaDto result = pizzaController.updatePizza(pizzaId, pizzaDto);

        // Assert
        assertEquals(pizzaDto, result);
        verify(pizzaService, times(1)).updatePizza(pizzaDto, pizzaId);
    }
}
