package react.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import react.dto.ProductDto;

/**
 * @author rudyhuang
 */
@SpringBootTest
public class ProductDaoTest {
	@Autowired
	private ProductDao productDao;

	@Test
	public void testList() {
		List<ProductDto> all = productDao.findAllProducts();
		Assert.assertEquals(17, all.size());
	}
}