package ru.vrn.rusap.shared.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import ru.vrn.rusap.shared.model.superclass.Access;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "Access_USB")
public class AccessUSB extends Access implements Serializable {
//  protected String email;
//
//  protected String dept;
//
//  public AccessUSB() {
//  }
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public String getDept() {
//    return dept;
//  }
//
//  public void setDept(String dept) {
//    this.dept = dept;
//  }
}