package com.NaSSIB.spring.SpringMongo.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;
import com.NaSSIB.spring.SpringMongo.repo.ViewerRepo;

@Service
public class ViewerServImpl implements ViewerServ {
  // logger
  private static final Logger log = LoggerFactory.getLogger(ViewerServImpl.class);

  // repo bean
  @Autowired
  ViewerRepo viewerRepo;

  // restTemplate bean
  @Autowired
  RestTemplate restTempl;

  // api uris
  public static final String ALL_VIEWERS_API = "http://localhost:8080/viewers";
  public static final String VIEWER_API = "http://localhost:8080/viewers/[id]";

  @Override
  public Iterable<Viewers> getAllViewers() {

    if (viewerRepo.count() != 0) {
      // if viewers exist in repo
      log.debug("found viewers in DB: " + viewerRepo.count());
      return viewerRepo.findAll();
    } else {
      // get viewers from api

      List<Viewers> viewerList;
      log.debug("getting viewers");

      // generate response entity
      ResponseEntity<List<Viewers>> viewersListResponse = restTempl.exchange(ALL_VIEWERS_API,
          HttpMethod.GET, null, new ParameterizedTypeReference<List<Viewers>>() {});

      // List<Viewers> viewerList = restTempl.getForObject(VIEWER_URI, List.class);
      if (viewersListResponse.getStatusCode() == HttpStatus.OK) {
        // viewer adding works
        viewerList = viewersListResponse.getBody();
        viewerList.forEach(v -> addViewer(v));
        // iterate = viewerList.iterator();
        log.debug("added viewers to db");
        return getAllViewers();
      } else {
        // not in repo and api failed
        log.error("bad http response, could not get viewers");
        return null;
      }
    }


  }

  @Override
  public Optional<Viewers> getViewer(int identity) {
    log.debug("serving viewer");
    return viewerRepo.findById(identity);

  }

  @Override
  public void addViewer(Viewers v) {
    log.debug("serv adding viewer");
    viewerRepo.insert(v);

  }

  @Override
  public void updateViewer(Viewers v) {
    addViewer(v);

  }

  @Override
  public void deleteViewer(int identity) {
    log.debug("deleting viewer");
    viewerRepo.deleteById(identity);
  }



}
