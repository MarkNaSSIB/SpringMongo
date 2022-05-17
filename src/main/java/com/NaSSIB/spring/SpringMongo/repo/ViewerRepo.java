package com.NaSSIB.spring.SpringMongo.repo;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;

public interface ViewerRepo extends MongoRepository<Viewers, String> {
  public Optional<Viewers> findById(int identity);

  public void deleteById(int identity);
}
