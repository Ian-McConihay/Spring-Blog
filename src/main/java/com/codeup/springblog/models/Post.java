package com.codeup.springblog.models;
import javax.persistence.*;
@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false)
	private String body;

	@ManyToOne
	@JoinColumn (name = "user_id")
	private User user;

	public Post(Long id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Post(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public Post() {

	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}


}
