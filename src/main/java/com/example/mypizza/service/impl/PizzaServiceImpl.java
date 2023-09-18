package com.example.mypizza.service.impl;

import com.example.mypizza.dto.PizzaDto;
import com.example.mypizza.mapper.PizzaMapper;
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
import java.util.stream.Collectors;

/**
 * Implementation of the PizzaService interface for handling pizza-related operations.
 */
@RequiredArgsConstructor
@Component
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    /**
     * Get a list of all pizzas.
     *
     * @return List of PizzaDto containing pizza information
     */
    @Override
    public List<PizzaDto> getPizzaList() {
        return pizzaRepository.findAll().stream()
                .map(pizzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get a pizza by its name.
     *
     * @param pizzaName Name of the pizza to retrieve
     * @return PizzaDto containing pizza information
     * @throws PizzaNotFoundException if the pizza with the given name is not found
     */
    @Override
    public PizzaDto getPizzaByName(String pizzaName) {
        Optional<Pizza> optionalPizza = pizzaRepository.findPizzasByName(pizzaName);
        return optionalPizza.map(pizzaMapper::toDTO).orElseThrow(
                () -> new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND));
    }

    /**
     * Add a new pizza.
     *
     * @param pizzaDto The pizza details to create
     * @return PizzaDto containing created pizza information
     */
    @Override
    public PizzaDto addPizza(PizzaDto pizzaDto) {
        Pizza pizza = pizzaMapper.toEntity(pizzaDto);
        return pizzaMapper.toDTO(pizza);
    }

    /**
     * Delete a pizza by its ID.
     *
     * @param id ID of the pizza to delete
     * @throws CafeNotFoundException if the pizza with the given ID is not found
     */
    @Override
    public void deletePizzaById(String id) {
        Optional<Pizza> existingPizza = pizzaRepository.findById(id);
        if (existingPizza.isPresent()) {
            pizzaRepository.deletePizzaById(id);
        } else {
            throw new CafeNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
        }
    }

    /**
     * Update a pizza by its ID.
     *
     * @param pizzaDto The updated pizza details
     * @param id ID of the pizza to update
     * @return PizzaDto containing updated pizza information
     * @throws CafeNotFoundException if the pizza with the given ID is not found
     */
    @Override
    public PizzaDto updatePizza(PizzaDto pizzaDto, String id) {
        Optional<Pizza> existingPizza = pizzaRepository.findPizzaById(id);
        Pizza pizza = pizzaMapper.toEntity(pizzaDto);
        if (existingPizza.isPresent()) {
            pizzaDto.setId(id);
            return pizzaMapper.toDTO(pizzaRepository.save(pizza));
        } else {
            throw new CafeNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}

