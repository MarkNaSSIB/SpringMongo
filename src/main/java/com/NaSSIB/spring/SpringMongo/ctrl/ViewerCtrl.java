package com.NaSSIB.spring.SpringMongo.ctrl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;
import com.NaSSIB.spring.SpringMongo.service.ViewerServImpl;


@RestController
public class ViewerCtrl {
  @Autowired
  ViewerServImpl viewerServ;

  private static final Logger log = LoggerFactory.getLogger(ViewerCtrl.class);

  @GetMapping("/")
  String home() {
    log.debug("hello :)");
    return "Hello :)";
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "Quintrix JFS") String name) {
    log.debug("hello " + name);
    return String.format("Hello %s!", name);
  }



  @GetMapping("/viewers")
  public Iterable<Viewers> getAllViewers(
      @RequestParam(name = "name", required = false) String name) {
    log.debug("finding all ctrl");
    // bad practice, will implement service later

    return viewerServ.getAllViewers();

  }

  // requestmap to add new film utilizing POST method
  @RequestMapping(method = RequestMethod.POST, value = "/viewers")
  public void addViewer(@RequestBody Viewers newView) {
    log.debug("Adding viewer: " + newView);
    viewerServ.addViewer(newView);
  }


  // requestmap for films with id, returns one film
  @RequestMapping(method = RequestMethod.GET, value = "/viewers/{id}")
  Optional<Viewers> getAViewer(@PathVariable("id") Integer identity) {

    log.debug("Getting viewr: " + identity);
    return viewerServ.getViewer(identity);

  }

  @DeleteMapping("viewers/{id}")
  public HttpStatus delete(@PathVariable("id") Integer identity) {
    try {
      log.debug("deleting viewer " + identity);
      viewerServ.deleteViewer(identity);
      return HttpStatus.OK;
    } catch (Exception e) {
      log.error("could not delete entry");
      return null;
    }

  }
}

