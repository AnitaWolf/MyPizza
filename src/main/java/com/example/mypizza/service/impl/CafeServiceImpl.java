package com.example.mypizza.service.impl;

import com.example.mypizza.dto.CafeDto;

import com.example.mypizza.mapper.CafeMapper;
import com.example.mypizza.model.Cafe;
import com.example.mypizza.repository.CafeRepository;
import com.example.mypizza.service.exeption.CafeNotFoundException;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.util.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
     * The mapper for converting between Cafe and CafeDto objects.
     */
    private final CafeMapper cafeMapper;

    /**
     * Get a list of all cafes.
     *
     * @return List of CafeDto objects representing cafes.
     */
    @Override
    public List<CafeDto> getCafeList() {
        List<Cafe> cafes=cafeRepository.findAll();
        return cafes.stream()
                .map(cafeMapper::toDTO)
                .collect(Collectors.toList());
    }
/**@Override
public List<OrderDto> getAllOrders() {
List<Order> orders = orderRepository.findAll();
return orders.stream()
.map(orderMapper::toDto)
.collect(Collectors.toList());
}
 */
    /**
     * Get cafe information by ID.
     *
     * @param id The ID of the cafe.
     * @return CafeDto representing the cafe.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public CafeDto getCafeById(String id) {
        return cafeMapper.toDTO(cafeRepository.findCafeById(id).orElseThrow(() -> new CafeNotFoundException(ErrorMessage.CAFE_NOT_FOUND)));
    }

    /**
     * Create a new cafe.
     *
     * @param cafeDto The cafe object to be created.
     * @return CafeDto representing the created cafe.
     */
    @Override
    public CafeDto addCafe(CafeDto cafeDto) {
        Cafe cafe = cafeMapper.toEntity(cafeDto);
        return cafeMapper.toDTO(cafe);
    }

    /**
     * Delete a cafe by ID.
     *
     * @param id The ID of the cafe to be deleted.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public void deleteCafeById(String id) {
        Optional<Cafe> existingCafe = cafeRepository.findById(id);
        if (existingCafe.isPresent()) {
            cafeRepository.deleteCafeById(id);
        } else {
            throw new CafeNotFoundException(ErrorMessage.CAFE_NOT_FOUND);
        }
    }

    /**
     * Update cafe information by ID.
     *
     * @param cafeDto The updated cafe object.
     * @param id      The ID of the cafe to be updated.
     * @return CafeDto representing the updated cafe.
     * @throws CafeNotFoundException if the cafe with the given ID is not found.
     */
    @Override
    public CafeDto updateCafe(CafeDto cafeDto, String id) {
        Optional<Cafe> existingCafe = cafeRepository.findById(id);
        Cafe cafe = cafeMapper.toEntity(cafeDto);
        if (existingCafe.isPresent()) {
            cafeDto.setId(id);
            return cafeMapper.toDTO(cafeRepository.save(cafe));
        } else {
            throw new CafeNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}