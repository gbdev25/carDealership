package daos;

import java.util.List;

import models.Offer;
import models.User;

public interface OfferDAO {
	Offer createOffer(Offer o);
	List<Offer> retrievePendingOffers();
	boolean desicionOffer(Offer o);
}
	
