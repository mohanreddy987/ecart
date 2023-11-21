package com.ecart.product;

import java.util.HashMap;
import java.util.Map;

import com.ecart.pojo.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Class for Electronics
 */
public class Electronics extends Product {

	public Electronics(Long id, String catalog,String name, double price, int inStock, String description, String imageName,
			String meta_info) {

		super(id, catalog,name, price, inStock, description, imageName, loadProperties(meta_info));

	}

	public static Map<String, String> loadProperties(String meta_info) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> properties = new HashMap<String, String>();
		try {
			JsonNode jsonData = objectMapper.readTree(meta_info);
			//properties.put("warranty", jsonData.get("warranty").asText());

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;

	}

}
