package com.example.mypizza.controller;

import com.example.mypizza.model.Pizza;
import com.example.mypizza.service.util.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for managing pizza operations.
 */
@RestController
@RequestMapping("/pizzas")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    /**
     * Get a list of all pizzas.
     *
     * @return List of all pizzas
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/admin")
    public List<Pizza> getAllPizzas() {
        return pizzaService.getPizzaList();
    }

    /**
     * Find all pizzas for a given cafe by its ID.
     *
     * @param cafeId Cafe ID
     * @return List of pizzas for the specified cafe
     */
    @GetMapping("/byCafeId/{cafeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> findAllByCafeId(@PathVariable String cafeId) {
        return pizzaService.findAllByCafeId(cafeId);
    }

    /**
     * Get a pizza by its ID.
     *
     * @param id Pizza ID
     * @return Pizza with the specified ID
     */
    @GetMapping("/byId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pizza getPizzaById(@PathVariable String id) {
        return pizzaService.findPizzaById(id);
    }

    /**
     * Get a pizza by its name.
     *
     * @param name Pizza name
     * @return Pizza with the specified name
     */
    @GetMapping("/byName/{name}")
    public Pizza getPizzaByName(@PathVariable String name) {
        return pizzaService.getPizzaByName(name);
    }

    /**
     * Create a new pizza.
     *
     * @param pizza Information about the new pizza
     * @return Created pizza
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/add")
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    /**
     * Delete a pizza by its ID.
     *
     * @param pizzaId Pizza ID to delete
     */
    @DeleteMapping("admin/{pizzaId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePizza(@PathVariable String pizzaId) {
        pizzaService.deletePizzaById(pizzaId);
    }

    /**
     * Update pizza information.
     *
     * @param id    Pizza ID
     * @param pizza New pizza information
     * @return Updated pizza
     */
    @PutMapping("admin/{id}")
    public Pizza updatePizza(@PathVariable String id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizza(pizza, id);
    }
}
