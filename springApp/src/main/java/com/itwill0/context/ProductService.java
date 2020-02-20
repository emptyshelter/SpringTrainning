package com.itwill0.context;

import java.util.List;

public class ProductService {
	private ProductDao productDao;
	public ProductService() {
		System.out.println("1.### ProductService()생성자");
	}
	public void setProductDao(ProductDao productDao) {
		System.out.println("2.### ProductService.seProductDao("+productDao+")");
		this.productDao = productDao;
	}
	public List<Product> productList(){
		return productDao.productList();
	}

}
