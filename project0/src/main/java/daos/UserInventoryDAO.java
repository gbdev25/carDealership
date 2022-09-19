package daos;

import java.util.List;

import models.Product;
import models.User;
import models.userInventory;

public interface UserInventoryDAO {
	userInventory getUserInventoryByUsername (String username);
	List<userInventory> retrieveProductsByUserId(userInventory ui);
	List<userInventory> remainingPaymentsList();
}
