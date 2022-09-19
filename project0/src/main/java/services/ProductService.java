package services;

import java.util.List;

import daos.ProductDAO;
import daos.ProductPostgres;
import models.Product;
import models.User;

public class ProductService {
private ProductDAO pd = new ProductPostgres();
	
	public List<Product> getProductsByUserId(int id){
		//
		return pd.retrieveProductsByUserId(id);
	}
	
	public List<Product> getProducts(){
		return pd.retrieveProducts();
		
	}
	public Product createProduct(Product p) {
		
			Product product = pd.createProduct(p);
			System.out.println("Product: " + product + " was created.");
			return product;
		}
		
		
		
		
	}

