/**
 * 
 */
package com.MyNas.Model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Amady
 *
 */
@Entity(name = "User")
public class User {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idUser" )
private Long id;

private String login;

private String password;

public User() {
	
}



public User(String login, String password) {
	super();
	this.login = login;
	this.password = password;
}



public User(Long id, String login, String password) {
	super();
	this.id = id;
	this.login = login;
	this.password = password;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Long getId() {
	return id;
}


}
