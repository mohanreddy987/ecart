package com.ecart.product;

import com.ecart.pojo.Product;
import com.ecart.product.Books;
import com.ecart.product.Electronics;
import com.ecart.repository.models.ProductEntity;
/**
 * Factory class to create of different types of products
 */
public class ProductsFactory {

	public static Product createProduct(String type, ProductEntity pe) {

		switch (type.toLowerCase()) {
		case "electronics":
			return new Electronics(pe.getId(),type, pe.getName(),pe.getPrice(), pe.getQuantityInStock(),
					pe.getDescription(), pe.getImage(), pe.getMetaInfo());
		case "books":
			return new Books(pe.getId(),type, pe.getName(), pe.getPrice(), pe.getQuantityInStock(),
					pe.getDescription(), pe.getImage(), pe.getMetaInfo());
		case "clothing":
			return new Fashion(pe.getId(),type, pe.getName(), pe.getPrice(), pe.getQuantityInStock(),
					pe.getDescription(), pe.getImage(), pe.getMetaInfo());
		default:
			throw new IllegalArgumentException("Unexpected value: " + type.toLowerCase());
		}
	}
}
