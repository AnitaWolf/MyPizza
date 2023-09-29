package com.example.mypizza.controller;



import com.example.mypizza.model.Pizza;
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
        List<Pizza> pizzas = new ArrayList<>();
        when(pizzaService.getPizzaList()).thenReturn(pizzas);

        // Act
        List<Pizza> result = pizzaController.getAllPizzas();

        // Assert
        assertEquals(pizzas, result);
        verify(pizzaService, times(1)).getPizzaList();
    }

    @Test
    void testGetPizzasByName() {
        // Arrange
        String pizzaName = "Margherita";
        Pizza pizza = new Pizza();
        when(pizzaService.getPizzaByName(pizzaName)).thenReturn(pizza);

        // Act
        Pizza result = pizzaController.getPizzaByName(pizzaName);

        // Assert
        assertEquals(pizza, result);
        verify(pizzaService, times(1)).getPizzaByName(pizzaName);
    }

    @Test
    void testCreatePizza() {
        // Arrange
        Pizza pizza = new Pizza();
        when(pizzaService.addPizza(pizza)).thenReturn(pizza);

        // Act
        Pizza result = pizzaController.createPizza(pizza);

        // Assert
        assertEquals(pizza, result);
        verify(pizzaService, times(1)).addPizza(pizza);
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
        Pizza pizza = new Pizza();
        when(pizzaService.updatePizza(pizza, pizzaId)).thenReturn(pizza);

        // Act
        Pizza result = pizzaController.updatePizza(pizzaId, pizza);

        // Assert
        assertEquals(pizza, result);
        verify(pizzaService, times(1)).updatePizza(pizza, pizzaId);
    }
}
