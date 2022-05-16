package id.co.acc.domain.brand.repositories;

import id.co.acc.domain.brand.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {

    @Query(" select a from Brand a where 1 = 1" +
            " and (lower(a.cdBrand) like concat('%', :filter, '%') or lower(a.descBrand) like concat('%', :filter, '%') or :filter IS NULL)")
    List<Brand> searchBrand(@Param(value = "filter") String filter);
}
