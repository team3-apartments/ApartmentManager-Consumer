package com.qa.apartmentManager.apartmentapi.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.apartmentManager.apartmentapi.persistence.domain.SentApartmentManager;

@Repository
public interface MongoApartmentManagerRepo extends MongoRepository<SentApartmentManager, Long>{

	
}
