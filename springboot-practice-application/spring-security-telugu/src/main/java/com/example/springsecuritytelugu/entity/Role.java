package com.example.springsecuritytelugu.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @NaturalId
  private String roleName;

  private String roleDescription;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }

  @Override
  public String toString() {
    return "Role{" +
      "roleName='" + roleName + '\'' +
      ", roleDescription='" + roleDescription + '\'' +
      '}';
  }
}
