package id.co.acc.domain.brand.dtos;

import id.co.acc.domain.base.dtos.BaseRequestSearchDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class BrandRequestDto {
        private Map<String, String> getListFilterUnitBrand;
}
