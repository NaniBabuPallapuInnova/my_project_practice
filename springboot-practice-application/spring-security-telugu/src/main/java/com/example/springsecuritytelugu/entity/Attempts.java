package com.example.springsecuritytelugu.entity;

import javax.persistence.*;

/**
 * Attempts entity to persist our invalid attempts count of employee
 */

@Entity
@Table(name = "login_attempts")
public class Attempts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;

  @Column(name = "emp_id")
  private String empId;
  private int count;

  public Attempts() {
  }

  public Attempts(Long id, String username, String empId, int count) {
    this.id = id;
    this.username = username;
    this.empId = empId;
    this.count = count;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "Attempts{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", empId='" + empId + '\'' +
      ", count=" + count +
      '}';
  }
}
