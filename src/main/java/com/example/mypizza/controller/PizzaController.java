package com.example.mypizza.controller;

import com.example.mypizza.dto.PizzaDto;
import com.example.mypizza.service.util.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling pizza-related operations.
 *
 * This controller provides endpoints to:
 * - Retrieve a list of all pizzas
 * - Retrieve a pizza by its name
 * - Create a new pizza
 * - Delete a pizza by its ID
 * - Update a pizza by its ID
 */
@RestController
@RequestMapping("/pizzas")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    /**
     * Get a list of all pizzas.
     *
     * @return List of PizzaDto containing pizza information
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PizzaDto> getAllPizzas() {
        return pizzaService.getPizzaList();
    }

    /**
     * Get a pizza by its name.
     *
     * @param name Name of the pizza to retrieve
     * @return PizzaDto containing pizza information
     */
    @GetMapping("/byName/{name}")
    public PizzaDto getPizzasByName(@PathVariable String name) {
        return pizzaService.getPizzaByName(name);
    }

    /**
     * Create a new pizza.
     *
     * @param pizzaDto The pizza details to create
     * @return PizzaDto containing created pizza information
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PizzaDto createPizza(@RequestBody PizzaDto pizzaDto) {
        return pizzaService.addPizza(pizzaDto);
    }

    /**
     * Delete a pizza by its ID.
     *
     * @param id ID of the pizza to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePizza(@PathVariable String id) {
        pizzaService.deletePizzaById(id);
    }

    /**
     * Update a pizza by its ID.
     *
     * @param id ID of the pizza to update
     * @param pizzaDto The updated pizza details
     * @return PizzaDto containing updated pizza information
     */
    @PutMapping("/{id}")
    public PizzaDto updatePizza(@RequestParam String id, @RequestBody PizzaDto pizzaDto) {
        return pizzaService.updatePizza(pizzaDto, id);
    }
}