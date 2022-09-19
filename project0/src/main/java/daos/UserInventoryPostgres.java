package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.User;
import models.userInventory;
import util.ConnectionUtil;

public class UserInventoryPostgres implements UserInventoryDAO {

	

	
	@Override
	public userInventory getUserInventoryByUsername(String username) {
		String sql = "select * from User_inventory where User_id  = ?;";
		userInventory ui = null;
		
		try (Connection c = ConnectionUtil.getLocalConnection();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ui = new userInventory();
				ui.setItemName(rs.getString("Item_name"));
				ui.setRemaining_payments(rs.getInt("remaining_payments"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ui;
	}
	
	@Override
	public List<userInventory> retrieveProductsByUserId(userInventory ui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<userInventory> remainingPaymentsList() {
		String sql = "select * from User_inventory where remaining_payments > 0;";
		
		List<userInventory> userInven = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getLocalConnection()){
	
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				userInventory ui = new userInventory();
				ui.setUserId(rs.getString("User_id"));
				ui.setItemName(rs.getString("Item_name"));
				ui.setRemaining_payments(rs.getInt("Remaining_payments"));
				
				userInven.add(ui);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInven;
	}

	
}
