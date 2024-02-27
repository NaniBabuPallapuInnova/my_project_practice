package com.example.springsecuritytelugu.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "emp_id")
  private String empId;
  @Column(name = "name")
  @Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "is_account_active", columnDefinition = "BIT DEFAULT 1")
  private Boolean activeAccount;

  @Column(name = "phone")
  @Length(max = 10, message = "phone number must be less than or equal to 10 characters")
  private String phone;

  @Column(name = "salary")
  @Min(value = 10000, message = "Salary must be greater than or equal to 10,000")
  private double salary;

  @Column(name = "doj")
  private String dateOfJoining;

  public Employee() {
  }

  public Employee(Long id, String empId, String name, String email, String password, Boolean activeAccount, String phone, double salary, String dateOfJoining) {
    this.id = id;
    this.empId = empId;
    this.name = name;
    this.email = email;
    this.password = password;
    this.activeAccount = activeAccount;
    this.phone = phone;
    this.salary = salary;
    this.dateOfJoining = dateOfJoining;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getActiveAccount() {
    return activeAccount;
  }

  public void setActiveAccount(Boolean activeAccount) {
    this.activeAccount = activeAccount != null ? activeAccount : true;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(String dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "id=" + id +
      ", empId='" + empId + '\'' +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", activeAccount=" + activeAccount +
      ", phone='" + phone + '\'' +
      ", salary=" + salary +
      ", dateOfJoining='" + dateOfJoining + '\'' +
      '}';
  }
}
