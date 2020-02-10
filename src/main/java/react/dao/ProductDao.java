package react.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import react.dto.ProductDto;
import react.model.Product;

/**
 * @author rudyhuang
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("SELECT new react.dto.ProductDto(p) FROM Product p")
	List<ProductDto> findAllProducts();

	@Query("SELECT DISTINCT new react.dto.ProductDto(p) FROM Product p JOIN p.availableSizes s WHERE s IN (:availableSizes)")
	List<ProductDto> findAllProductsFilterByAvailableSizes(@Param("availableSizes") List<String> availableSizes);
}
