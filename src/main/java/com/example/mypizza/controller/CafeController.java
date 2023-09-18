package com.example.mypizza.controller;

import com.example.mypizza.dto.CafeDto;
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
    @GetMapping
    public List<CafeDto> getAllCafes() {
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
    public CafeDto getCafeById(@PathVariable String id) {
        return cafeService.getCafeById(id);
    }

    /**
     * Create a new cafe.
     *
     * @param cafeDto The cafe object to be created.
     * @return CafeDto representing the created cafe.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CafeDto createCafe(@RequestBody CafeDto cafeDto) {
        return cafeService.addCafe(cafeDto);
    }

    /**
     * Delete a cafe by ID.
     *
     * @param id The ID of the cafe to be deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCafe(@PathVariable String id) {
        cafeService.deleteCafeById(id);
    }

    /**
     * Update cafe information by ID.
     *
     * @param id      The ID of the cafe to be updated.
     * @param cafeDto The updated cafe object.
     * @return CafeDto representing the updated cafe.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CafeDto updateCafe(@RequestParam String id, @RequestBody CafeDto cafeDto) {
        return cafeService.updateCafe(cafeDto, id);
    }
}