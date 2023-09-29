package com.example.mypizza.service.impl;


import com.example.mypizza.model.Pizza;
import com.example.mypizza.repository.PizzaRepository;
import com.example.mypizza.service.exeption.CafeNotFoundException;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.exeption.PizzaNotFoundException;
import com.example.mypizza.service.util.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Implementation of the PizzaService interface for handling pizza-related operations.
 */
@RequiredArgsConstructor
@Component
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;


    /**
     * Get a list of all pizzas.
     *
     * @return List of Pizza containing pizza information
     */
    @Override
    public List<Pizza> getPizzaList() {

        return pizzaRepository.findAll();
    }
    /**
     * Finds a pizza by its unique identifier.
     *
     * @param id The unique identifier of the pizza to find.
     * @return The pizza with the specified ID.
     * @throws PizzaNotFoundException if no pizza is found with the given ID.
     */
    @Override
    public Pizza findPizzaById(String id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (pizza.isPresent()) {
            return pizza.get();
        } else
            throw new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
    }

    /**
     * Get a pizza by its name.
     *
     * @param pizzaName Name of the pizza to retrieve
     * @return Pizza containing pizza information
     * @throws PizzaNotFoundException if the pizza with the given name is not found
     */
    @Override
    public Pizza getPizzaByName(String pizzaName) {
        Pizza pizza = pizzaRepository.findPizzaByName(pizzaName);
        if (pizza == null) {
            throw new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
        }
        return pizza;
    }

    /**
     * Add a new pizza.
     *
     * @param pizza The pizza details to create
     * @return Pizza containing created pizza information
     */
    @Override
    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    /**
     * Delete a pizza by its ID.
     *
     * @param id ID of the pizza to delete
     * @throws PizzaNotFoundException if the pizza with the given ID is not found
     */
    @Override
    public void deletePizzaById(String id) {
        Optional<Pizza> existingPizza = pizzaRepository.findPizzaById(id);
        if (existingPizza.isPresent()) {
            pizzaRepository.deleteById(id);
        } else {
            throw new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
        }
    }

    /**
     * Update a pizza by its ID.
     *
     * @param updatedPizza The updated pizza details
     * @param id           ID of the pizza to update
     * @return Pizza containing updated pizza information
     * @throws CafeNotFoundException if the pizza with the given ID is not found
     */
    @Override
    public Pizza updatePizza(Pizza updatedPizza, String id) {
        Optional<Pizza> optionalPizza = pizzaRepository.findPizzaById(id);
        if (optionalPizza.isPresent()) {
            Pizza existingPizza = optionalPizza.get();
            // Update the pizza properties
            existingPizza.setName(updatedPizza.getName());
            existingPizza.setSize(updatedPizza.getSize());
            existingPizza.setPrice(updatedPizza.getPrice());
            existingPizza.setDescription(updatedPizza.getDescription());

            // Save the updated pizza
            return pizzaRepository.save(existingPizza);

        } else {
            throw new PizzaNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
    /**
     * Finds all pizzas associated with a cafe by its ID.
     *
     * @param cafeId The ID of the cafe to find pizzas for.
     * @return List of pizzas associated with the given cafe ID.
     * @throws PizzaNotFoundException if no pizzas are associated with the cafe ID.
     */
    @Override
    public List<Pizza> findAllByCafeId(String cafeId) {
        List<Pizza> pizzaList = pizzaRepository.findAllByCafeId(cafeId);
        if (pizzaList.isEmpty()) {
            throw new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
        }
        return pizzaList;
    }
}

