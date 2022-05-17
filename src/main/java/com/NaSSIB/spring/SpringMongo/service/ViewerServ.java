package com.NaSSIB.spring.SpringMongo.service;

import java.util.Optional;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;

public interface ViewerServ {

  public Iterable<Viewers> getAllViewers();

  public Optional<Viewers> getViewer(int identity);

  public void addViewer(Viewers v);

  public void updateViewer(Viewers v);

  public void deleteViewer(int identity);
}
