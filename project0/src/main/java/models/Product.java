package models;

import java.util.Objects;

public class Product {
	private int Product_id;
	private String Product_name;
	private String Product_description;
	private int Product_price;
	private User Product_owner;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_description() {
		return Product_description;
	}
	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}
	public int getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(int product_price) {
		Product_price = product_price;
	}
	public User getProduct_owner() {
		return Product_owner;
	}
	public void setProduct_owner(User product_owner) {
		Product_owner = product_owner;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Product_description, Product_id, Product_name, Product_owner, Product_price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(Product_description, other.Product_description) && Product_id == other.Product_id
				&& Objects.equals(Product_name, other.Product_name)
				&& Objects.equals(Product_owner, other.Product_owner) && Product_price == other.Product_price;
	}
	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", Product_name=" + Product_name + ", Product_description="
				+ Product_description + ", Product_price=" + Product_price + ", Product_owner=" + Product_owner + "]";
	}
	
}
