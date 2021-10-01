package com.mefunny.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "Meme")
public class Meme {
	
	@Id
	@Column(name = "memeID")
	@GeneratedValue(generator = "meme_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "meme_id_seq", sequenceName = "meme_id_seq")
	private int memeID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="likes",nullable=false)
	private int likes;
	
	@Column(name="dislikes",nullable=false)
	private int dislikes;
	
	@Column(name="username")
	private String userName;
	//private variable image;

	
	
	public int getMemeID() {
		return memeID;
	}

	public Meme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meme(int memeID, String name, String description, int likes, int dislikes, String userName) {
		super();
		this.memeID = memeID;
		this.name = name;
		this.description = description;
		this.likes = likes;
		this.dislikes = dislikes;
		this.userName = userName;
	}

	public void setMemeID(int memeID) {
		this.memeID = memeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + dislikes;
		result = prime * result + likes;
		result = prime * result + memeID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meme other = (Meme) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dislikes != other.dislikes)
			return false;
		if (likes != other.likes)
			return false;
		if (memeID != other.memeID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meme [memeID=" + memeID + ", name=" + name + ", description=" + description + ", likes=" + likes
				+ ", dislikes=" + dislikes + ", userName=" + userName + "]";
	}

	
	
	
}
