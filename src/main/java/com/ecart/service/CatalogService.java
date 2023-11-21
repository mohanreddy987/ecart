package com.ecart.service;

import java.util.List;
import java.util.Map;

import com.ecart.pojo.Product;



public interface CatalogService {
	
	public Map<String, List<Product>> loadCatalog();
	
}
