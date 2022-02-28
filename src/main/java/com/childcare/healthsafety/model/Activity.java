package com.childcare.healthsafety.model;

import javax.persistence.*;

@Entity // because there is a database
@Table(name = "activities")// names a table activities
public class Activity {




  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String number;

  @Column
  private String name;

  public Activity(Long id, String number, String name) {
    this.id = id;
    this.number = number;
    this.name = name;
  }

  public Activity() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

