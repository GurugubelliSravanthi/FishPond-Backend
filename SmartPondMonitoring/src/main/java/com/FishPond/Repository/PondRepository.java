package com.FishPond.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.FishPond.Entity.Pond;



public interface PondRepository extends MongoRepository<Pond, String> {
}