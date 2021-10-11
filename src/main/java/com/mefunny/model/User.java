package com.mefunny.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "id_seq", sequenceName = "id_seq")
	private int userId;
	
	@Column(name = "username",unique=true, nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

	
	
	
}