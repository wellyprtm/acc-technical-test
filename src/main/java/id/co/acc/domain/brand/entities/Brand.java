package id.co.acc.domain.brand.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
@Setter
@Getter
public class Brand {

    @Id
    @Column(name = "code_brand")
    private String cdBrand;

    @Column(name = "desc_brand")
    private String descBrand;
}
