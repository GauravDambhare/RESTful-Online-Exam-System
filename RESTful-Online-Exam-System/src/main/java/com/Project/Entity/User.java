
package com.Project.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	public String username;
	public String password;
	public long mobileno;
	public String email;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long mobileno() {
		return mobileno;
	}
	public void setMobno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", mobno=" + mobileno + ", email=" + email
				+ "]";
	}
	
	
	
}
