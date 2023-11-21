package com.ecart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.pojo.Product;
import com.ecart.product.ProductsFactory;
import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.ProductEntity;
/**
 * Class that provides the services that are related to cataog.
 */
@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	ProductRepository productRepo;

	@Override
	public Map<String, List<Product>> loadCatalog() {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntities = productRepo.findAll();
		Map<String, List<Product>> catalog = new HashMap<String, List<Product>>();
		
		for(ProductEntity entity: productEntities) {
			String type = entity.getCatalogName().toLowerCase();
			if(!catalog.containsKey(type)) {
				catalog.put(type, new ArrayList<Product>());
			}
			Product product = ProductsFactory.createProduct(type, entity);
			catalog.get(type).add(product);
		}
		return catalog;
	}
		
}
