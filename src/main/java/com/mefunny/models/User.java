package com.mefunny.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name="userID")
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "user_id_seq", sequenceName = "user_id_seq")
	private int userID;
	
	@Column(name = "username",unique=true, nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;


	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + "]";
	}
}
