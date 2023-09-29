package com.example.mypizza.service.impl;


import com.example.mypizza.model.Cafe;
import com.example.mypizza.model.Pizza;
import com.example.mypizza.repository.CafeRepository;
import com.example.mypizza.service.exeption.CafeNotFoundException;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.exeption.PizzaNotFoundException;
import com.example.mypizza.service.util.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;



/**
 * Implementation of the CafeService interface for managing cafes.
 */
@RequiredArgsConstructor
@Component
public class CafeServiceImpl implements CafeService {

    /**
     * The repository for accessing cafe data.
     */
    private final CafeRepository cafeRepository;

    /**
     * Get a list of all cafes.
     *
     * @return List of Cafe objects representing cafes.
     */
    @Override
    public List<Cafe> getCafeList() {
        return cafeRepository.findAll();
    }

    /**
     * Get cafe information by ID.
     *
     * @param id The ID of the cafe.
     * @return Cafe representing the cafe.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public Cafe getCafeById(String id) {
        Optional<Cafe> cafe = cafeRepository.findCafeById(id);
        if (cafe.isPresent()) {
            return cafe.get();
        } else throw new CafeNotFoundException(ErrorMessage.CAFE_NOT_FOUND);
    }

    /**
     * Create a new cafe.
     *
     * @param cafe The cafe object to be created.
     * @return Cafe representing the created cafe.
     */
    @Override
    public Cafe addCafe(Cafe cafe) {

        return cafeRepository.save(cafe);
    }

    /**
     * Delete a cafe by ID.
     *
     * @param id The ID of the cafe to be deleted.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public void deleteCafeById(String id) {
        Optional<Cafe> existingCafe = cafeRepository.findCafeById(id);
        if (existingCafe.isPresent()) {
            cafeRepository.deleteById(id);
        } else {
            throw new CafeNotFoundException(ErrorMessage.CAFE_NOT_FOUND);
        }
    }

    /**
     * Updates an existing cafe with the provided information.
     *
     * @param updatecafe The updated cafe information.
     * @param id         The ID of the cafe to update.
     * @return The updated cafe.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public Cafe updateCafe(Cafe updatecafe, String id) {
        Optional<Cafe> optionalCafe = cafeRepository.findById(id);
        if (optionalCafe.isPresent()) {
            Cafe existingCafe = optionalCafe.get();
            existingCafe.setName(updatecafe.getName());
            existingCafe.setLocation(updatecafe.getLocation());
            existingCafe.setPhone(updatecafe.getPhone());
            return cafeRepository.save(existingCafe);
        } else {
            throw new CafeNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    /**
     * Finds a cafe based on the name of a pizza associated with it.
     *
     * @param pizzaName The name of the pizza to find the associated cafe.
     * @return The cafe associated with the given pizza name.
     * @throws CafeNotFoundException if no cafe is associated with the pizza name.
     */
    @Override
    public Cafe findCafeByPizzaName(String pizzaName) {
        Cafe cafe = cafeRepository.findCafeByPizzaName(pizzaName);
        if (cafe == null) {
            throw new CafeNotFoundException(ErrorMessage.CAFE_NOT_FOUND);
        }
        return cafe;
    }

    /**
     * Finds a list of pizzas associated with a cafe by its name.
     *
     * @param cafeName The name of the cafe to find pizzas for.
     * @return List of pizzas associated with the given cafe name.
     * @throws PizzaNotFoundException if no pizzas are associated with the cafe name.
     */
    @Override
    public List<Pizza> findPizzasByCafeName(String cafeName) {
        List<Pizza> pizzaList = cafeRepository.findAllPizzaByCafeName(cafeName);
        if (pizzaList.isEmpty()) {
            throw new PizzaNotFoundException(ErrorMessage.PIZZA_NOT_FOUND);
        }
        return pizzaList;
    }
}