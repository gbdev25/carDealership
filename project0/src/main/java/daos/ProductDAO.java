package daos;

import java.util.List;

import models.Product;
import models.User;

public interface ProductDAO {

	Product createProduct(Product t);
	List<Product> retrieveProducts();
	Product retrieveProductById(int Product_id);
	List<Product> retrieveProductsByUserId(int id);
	boolean updateProduct(Product t);
	List<Product> retrieveProductsCust();
	boolean deleteProductById(int Product_id);
	
	
}
