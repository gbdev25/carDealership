package models;

import java.util.Objects;

public class userInventory {
	private int inventoryId;
	private String itemName;
	private int remaining_payments;
	private String userId;
	public userInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getRemaining_payments() {
		return remaining_payments;
	}
	public void setRemaining_payments(int remaining_payments) {
		this.remaining_payments = remaining_payments;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(inventoryId, itemName, remaining_payments, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userInventory other = (userInventory) obj;
		return inventoryId == other.inventoryId && Objects.equals(itemName, other.itemName)
				&& remaining_payments == other.remaining_payments && userId == other.userId;
	}
	@Override
	public String toString() {
		return "userInventory [inventoryId=" + inventoryId + ", itemName=" + itemName + ", remaining_payments="
				+ remaining_payments + ", userId=" + userId + "]";
	}
	
}
