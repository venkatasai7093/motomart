package com.tradehub.bikes_marketplace.service;

import com.tradehub.bikes_marketplace.dto.BikeCreateDto;
import com.tradehub.bikes_marketplace.dto.BikeResponseDto;
import com.tradehub.bikes_marketplace.model.Bike;
import com.tradehub.bikes_marketplace.model.User;
import com.tradehub.bikes_marketplace.repository.BikeRepository;
import com.tradehub.bikes_marketplace.repository.UserRepository;
import com.tradehub.bikes_marketplace.transformers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BikeService {
    private final BikeRepository bikeRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public BikeResponseDto createBike(BikeCreateDto dto,String username){
        User seller = userRepository.findByEmail(username);

        Bike bike = userMapper.toEntity(dto);
        bike.setCreatedAt(LocalDateTime.now());
        bike.setSold(false);
        bike.setSeller(seller);

        Bike saved = bikeRepository.save(bike);
        return userMapper.toResponseDto(saved);
    }

    @Cacheable(value = "bikeSearchCache", key = "#brand + '-' + #minPrice + '-' + #maxPrice + '-' + #location + '-' + #pageable.pageNumber")
    public Page<BikeResponseDto> searchBikes(String brand, Double minPrice, Double maxPrice,
                                             String location , Pageable pageable){
        Specification<Bike> spec = Specification.where(null);

        if(brand != null) spec = spec.and((root, query, cb) -> cb.equal(root.get("brand"), brand));
        if(minPrice != null) spec = spec.and((root, query, cb) -> cb.ge(root.get("price"),minPrice));
        if(maxPrice != null) spec = spec.and((root, query, cb) -> cb.le(root.get("price"),maxPrice));
        if(location != null) spec = spec.and((root, query, cb) -> cb.like(root.get("location"), "%" + location + "%"));

        return bikeRepository.findAll(spec,pageable)
                .map(userMapper::toResponseDto);
    }
}
