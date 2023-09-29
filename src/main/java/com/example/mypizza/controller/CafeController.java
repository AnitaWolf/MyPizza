package com.example.mypizza.controller;


import com.example.mypizza.model.Cafe;
import com.example.mypizza.model.Pizza;
import com.example.mypizza.service.util.CafeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller class for managing cafes.
 */
@RestController
@RequestMapping("/cafes")
@AllArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    /**
     * Get a list of all cafes.
     *
     * @return List of CafeDto objects representing cafes.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("admin/all")
    public List<Cafe> getAllCafes() {
        return cafeService.getCafeList();
    }

    /**
     * Get cafe information by ID.
     *
     * @param id The ID of the cafe.
     * @return CafeDto representing the cafe.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cafe getCafeById(@PathVariable String id) {
        return cafeService.getCafeById(id);
    }

    /**
     * Retrieve a cafe by the name of a specific pizza.
     *
     * @param pizzaName The name of the pizza to find the cafe for.
     * @return The cafe associated with the given pizza name.
     */
    @GetMapping("/byPizzaName/{pizzaName}")
    public Cafe getCafeByPizzaName(@PathVariable String pizzaName) {
        return cafeService.findCafeByPizzaName(pizzaName);
    }

    /**
     * Retrieve a list of pizzas associated with a cafe by its name.
     *
     * @param cafeName The name of the cafe to find pizzas for.
     * @return List of pizzas associated with the given cafe name.
     */
    @GetMapping("/byCafeName/{cafeName}")
    public List<Pizza> getPizzasByCafeName(@PathVariable String cafeName) {
        return cafeService.findPizzasByCafeName(cafeName);
    }

    /**
     * Create a new cafe.
     *
     * @param cafe The cafe object to be created.
     * @return CafeDto representing the created cafe.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin")
    public Cafe createCafe(@RequestBody Cafe cafe) {
        return cafeService.addCafe(cafe);
    }

    /**
     * Delete a cafe by ID.
     *
     * @param id The ID of the cafe to be deleted.
     */
    @DeleteMapping("admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCafe(@PathVariable String id) {
        cafeService.deleteCafeById(id);
    }

    /**
     * Update cafe information by ID.
     *
     * @param id   The ID of the cafe to be updated.
     * @param cafe The updated cafe object.
     * @return CafeDto representing the updated cafe.
     */
    @PutMapping("admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cafe updateCafe(@PathVariable String id, @RequestBody Cafe cafe) {
        return cafeService.updateCafe(cafe, id);
    }
}