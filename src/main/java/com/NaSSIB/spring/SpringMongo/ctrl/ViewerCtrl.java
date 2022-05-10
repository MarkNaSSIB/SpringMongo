package com.NaSSIB.spring.SpringMongo.ctrl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringMongo.entity.Viewers;
import com.NaSSIB.spring.SpringMongo.repo.ViewerRepo;


@RestController
public class ViewerCtrl {
  @Autowired
  ViewerRepo viewRepo;
  private static final Logger log = LoggerFactory.getLogger(ViewerCtrl.class);

  @GetMapping("/")
  String home() {
    log.debug("hello :)");
    return "Hello :)";
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "Quintrix JFS") String name) {
    return String.format("Hello %s!", name);
  }



  @RequestMapping(method = RequestMethod.GET, value = "/viewers")
  public List<Viewers> getAllViewers(@RequestParam(name = "name", required = false) String name) {
    log.debug("finding all ctrl");
    // bad practice, will implement service later
    return viewRepo.findAll();


  }
}

