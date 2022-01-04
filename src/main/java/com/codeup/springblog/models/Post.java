package com.codeup.springblog.models;
import javax.persistence.*;
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String title;
	@Column(nullable = false)
	private String body;


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
