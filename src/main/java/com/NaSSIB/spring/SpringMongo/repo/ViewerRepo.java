package com.NaSSIB.spring.SpringMongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;

public interface ViewerRepo extends MongoRepository<Viewers, String> {
  //
}
