package ru.vrn.rusap.shared.model.superclass;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import ru.vrn.rusap.shared.model.UsersAD;

@MappedSuperclass
public abstract class Access extends Modification implements Serializable {


  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_USER_AD", referencedColumnName = "ID")
  private UsersAD homeAddress;

//  @Id
//  @Column(nullable = false)
//  @GeneratedValue
//  private Long id;

  public Access() {
  }
  public UsersAD getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(UsersAD homeAddress) {
    this.homeAddress = homeAddress;
  }

//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }

}