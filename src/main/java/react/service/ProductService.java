/* ProductService.java

	Purpose:
		
	Description:
		
	History:
		Fri Dec 20 15:04:41 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package react.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import react.dao.ProductDao;
import react.dto.ProductDto;

/**
 * @author rudyhuang
 */
@Service
@Transactional
public class ProductService {
	private final ProductDao productDao;

	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<ProductDto> getProducts() {
		return productDao.findAllProducts();
	}
}
