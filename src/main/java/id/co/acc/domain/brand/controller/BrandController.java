package id.co.acc.domain.brand.controller;

import id.co.acc.domain.base.dtos.ApiResponse;
import id.co.acc.domain.base.dtos.BaseRequestSearchDto;
import id.co.acc.domain.brand.dtos.BrandRequestDto;
import id.co.acc.domain.brand.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/public/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(value = "search")
    public ApiResponse search(@RequestBody BaseRequestSearchDto body) {
        String param = body.getPSearch();
        return ApiResponse.data(brandService.search(param));
    }
}
