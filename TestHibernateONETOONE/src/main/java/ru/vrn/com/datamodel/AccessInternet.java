package ru.vrn.com.datamodel;

import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Access;


@Entity
@Table(name = "Access_Internet")
public class AccessInternet extends Access {

}
