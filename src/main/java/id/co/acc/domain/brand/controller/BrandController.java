package id.co.acc.domain.brand.controller;

import id.co.acc.domain.base.dtos.ApiResponse;
import id.co.acc.domain.base.dtos.BaseRequestSearchDto;
import id.co.acc.domain.brand.dtos.BrandRequestDto;
import id.co.acc.domain.brand.services.BrandService;
import id.co.acc.domain.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api/public/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(value = "search")
    public ApiResponse search(@RequestBody BrandRequestDto body) {
        String param = body.getGetListFilterUnitBrand().get("P_SEARCH");
        if (validateParam(param)) {
            return ApiResponse.data(brandService.search(param));
        } else {
            throw new BadRequestException("Invalid input");
        }
    }

    private boolean validateParam(String param) {
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(param);
        boolean hasSpecialCharacter = matcher.find();
        if (hasSpecialCharacter) {
            return false;
        }

        return param.length() <= 10;
    }
}
