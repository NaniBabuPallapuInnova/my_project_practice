package com.example.springsecuritytelugu.dto;


import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) //To explicitly tell JAXB to ignore properties(setters & getters) and only use fields(variable)
//@XmlAccessorType(XmlAccessType.PROPERTY) //To explicitly tell JAXB to ignore fields(variable) and only use properties(setters & getters)
public class EmployeeDTO {
  @XmlElement
  private Long id;

  @XmlElement
  private String empId;
  @XmlElement

  private String name;
  @XmlElement

  private String email;
  @XmlElement
  private String password;
  @XmlElement

  private Boolean activeAccount;
  @XmlElement

  private String phone;
  @XmlElement
  private double salary;
  @XmlElement

  private String dateOfJoining;

  public EmployeeDTO() {
  }

  public EmployeeDTO(Long id, String empId, String name, String email, String password, Boolean activeAccount, String phone, double salary, String dateOfJoining) {
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
    this.activeAccount = activeAccount;
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
    return "EmployeeDTO{" +
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
