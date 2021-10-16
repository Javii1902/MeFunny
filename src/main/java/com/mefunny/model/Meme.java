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
@Table(name = "memes")
public class Meme {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "id_seq", sequenceName = "id_seq")
	private int id;
	
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
	
	@Column(name="caption")
	private String caption;
	//private variable image;

	public Meme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meme(int id, String name, String description, int likes, int dislikes, String userName, String caption) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.likes = likes;
		this.dislikes = dislikes;
		this.userName = userName;
		this.caption = caption;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public int hashCode() {
		return Objects.hash(caption, description, dislikes, id, likes, name, userName);
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
		return Objects.equals(caption, other.caption) && Objects.equals(description, other.description)
				&& dislikes == other.dislikes && id == other.id && likes == other.likes
				&& Objects.equals(name, other.name) && Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "Meme [id=" + id + ", name=" + name + ", description=" + description + ", likes=" + likes + ", dislikes="
				+ dislikes + ", userName=" + userName + ", caption=" + caption + "]";
	}

	
	
	
}
