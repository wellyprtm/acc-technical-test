package id.co.acc.domain.brand.services;

import id.co.acc.domain.brand.dtos.BrandDto;
import id.co.acc.domain.brand.entities.Brand;
import id.co.acc.domain.brand.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDto> search(String filter) {
        List<Brand> brands = brandRepository.searchBrand(filter.toLowerCase());
        return BrandDto.fromEntities(brands);
//        return new ArrayList<>();
    }
}
