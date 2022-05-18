package id.co.acc.domain.brand.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.acc.domain.brand.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {

    @JsonProperty(value = "CD_BRAND")
    private String cdBrand;

    @JsonProperty(value = "DESC_BRAND")
    private String descBrand;

    public static List<BrandDto> fromEntities(List<Brand> entities) {
        List<BrandDto> dtos = new ArrayList<>();
        for (Brand brand: entities) {
            dtos.add(new BrandDto(brand.getCdBrand(), brand.getDescBrand()));
        }
        return dtos;
    }
}
