package ru.vrn.rusap.shared.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.rusap.shared.model.superclass.Access;


@Entity
@Table(name = "Access_Internet")
public class AccessInternet extends Access {

}
