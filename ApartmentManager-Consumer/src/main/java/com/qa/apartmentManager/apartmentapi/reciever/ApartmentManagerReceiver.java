package com.qa.apartmentManager.apartmentapi.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.apartmentManager.apartmentapi.persistence.domain.SentApartmentManager;
import com.qa.apartmentManager.apartmentapi.persistence.repository.MongoApartmentManagerRepo;

@Component
public class ApartmentManagerReceiver {

	@Autowired
	private MongoApartmentManagerRepo repo;
	
	private static Long staticApartmentId = 1l;
	
	@JmsListener(destination = "ApartmentManagerQueue", containerFactory = "myFactory")
	public void recieveMessage(SentApartmentManager sentApartmentManager) {
		for(Long i = 1L; i<=repo.findAll().size(); i++) {
			if ((repo.findById(i) != null)) {
				staticApartmentId = i+1;
			}
		}
		sentApartmentManager.setApartmentId(staticApartmentId);
		repo.save(sentApartmentManager);
	}

}
