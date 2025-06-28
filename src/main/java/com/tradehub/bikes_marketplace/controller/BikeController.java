package com.tradehub.bikes_marketplace.controller;

import com.tradehub.bikes_marketplace.dto.BikeCreateDto;
import com.tradehub.bikes_marketplace.dto.BikeResponseDto;
import com.tradehub.bikes_marketplace.service.BikeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
@Slf4j
public class BikeController {

    private final BikeService bikeService;

    @PostMapping("/bikes/createbike")
    public ResponseEntity<BikeResponseDto> createBike(@RequestBody @Valid BikeCreateDto dto,
                                                      @AuthenticationPrincipal UserDetails user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bikeService.createBike(dto,user.getUsername()));
    }

    @GetMapping("/bikes/getbikes")
    public Page<BikeResponseDto> getBikes(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String location,
            @PageableDefault(size = 10,sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable
            ){
        log.info("Received request to get bikes with filters: brand={}, minPrice={}, maxPrice={}, location={}, pageable={}",
                brand, minPrice, maxPrice, location, pageable);
        return bikeService.searchBikes(brand,minPrice,maxPrice,location,pageable);
    }
}
