package com.example.springsecuritytelugu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

  @Id
  private String userName;
  private String userFirstName;
  private String userLastName;
  private String userPassword;

  /**
   * Certainly! Let's break down the code with comments for better explanation:
   * Explanation:
   *
   * 1. `@ManyToMany`: Annotation indicating a many-to-many relationship between `User` and `Role`. A user can have multiple roles, and a role can be associated with multiple users.
   *
   * 2. `fetch = FetchType.EAGER`: Specifies that when loading a `User` entity, load its associated `Role` entities eagerly (i.e., fetch them immediately).
   *
   * 3. `cascade = CascadeType.ALL`: Indicates that all operations (persist, merge, remove, refresh) should be cascaded to the associated `Role` entities. For example, if a `User` is deleted, associated roles will also be deleted.
   *
   * 4. `@JoinTable`: Specifies the details of the join table that is used to represent the many-to-many relationship in the database.
   *
   *    - `name = "user_roles"`: The name of the join table.
   *    - `joinColumns`: Specifies the foreign key column in the join table that references the primary key column of the owning entity (`User`).
   *    - `inverseJoinColumns`: Specifies the foreign key column in the join table that references the primary key column of the inverse side entity (`Role`).
   *
   * 5. `private Set<Role> roles;`: Represents the set of `Role` entities associated with the user. This set will be populated based on the many-to-many relationship defined.
   *
   * This setup allows a `User` to have multiple roles, and the roles are stored in a separate join table (`user_roles`) in the database.
   */
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "user_role",
    joinColumns = {
    @JoinColumn(name = "user_name")
    },
    inverseJoinColumns = {
    @JoinColumn(name = "role_name")
    }
  )
  private Set<Role> roles;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserFirstName() {
    return userFirstName;
  }

  public void setUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User{" +
      "userName='" + userName + '\'' +
      ", userFirstName='" + userFirstName + '\'' +
      ", userLastName='" + userLastName + '\'' +
      ", userPassword='" + userPassword + '\'' +
      ", roles=" + roles +
      '}';
  }
}
