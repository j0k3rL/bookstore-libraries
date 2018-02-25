package com.bookstore.libraries.validation;

import com.bookstore.libraries.validation.annotation.ProductCodeValid;

public class CollectionElementBean {

	@ProductCodeValid
	private String productCodeValid;

	protected CollectionElementBean() {
		
	}
	
	public String getProductCodeValid() {
		return productCodeValid;
	}

	public void setProductCodeValid(String productCodeValid) {
		this.productCodeValid = productCodeValid;
	}
}