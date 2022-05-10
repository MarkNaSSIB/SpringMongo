package com.NaSSIB.spring.SpringMongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "viewers")
public class Viewers {
  @Id
  private Integer id;

  private String name;
  private String email;
  private String gender;
  private String status;


  @Override
  public String toString() {
    return "Viewers [id: " + id + ", name:" + name + "]";
  }

  public Viewers() {
    super();
  }

  public Viewers(Integer id, String name, String email, String gender, String status) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}

