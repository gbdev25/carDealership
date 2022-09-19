
package models;

import java.util.Objects;

public class Offer {
	private int offerAmount;
	private String offerStatus;
	private String offerUsername;
	private int offerId;
	private int productId;
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	public String getOfferStatus() {
		return offerStatus;
	}
	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	public String getUsername() {
		return offerUsername;
	}
	public void setUsername(String username) {
		this.offerUsername = username;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(offerAmount, offerId, offerStatus, productId, offerUsername);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return offerAmount == other.offerAmount && offerId == other.offerId
				&& Objects.equals(offerStatus, other.offerStatus) && productId == other.productId
				&& Objects.equals(offerUsername, other.offerUsername);
	}
	@Override
	public String toString() {
		return "OfferAmount: " + offerAmount + 
				" OfferStatus: " + offerStatus + 
				" Username: " + offerUsername +
				" OfferId: " + offerId + 
				" ProductId: " + productId ;
	
	
}
}
