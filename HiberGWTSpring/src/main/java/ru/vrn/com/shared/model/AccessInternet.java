package ru.vrn.com.shared.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.shared.model.superclass.Access;


@Entity
@Table(name = "Access_Internet")
public class AccessInternet extends Access {

}
