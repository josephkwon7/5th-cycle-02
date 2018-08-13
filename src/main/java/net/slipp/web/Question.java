package net.slipp.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.slipp.domain.User;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;
	
	private String title;
	
	private String content;
	
	private LocalDateTime createDate;
	
	public Question() {} //JPA requires this default constructor

	public Question(User writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createDate = LocalDateTime.now();
	}
	
	//this method is NOT necessary spring-boot 2.x handles it's format automatically
	public String getFormattedCreateDate() {
		if (createDate == null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}

	public Long getId() {
		return id;
	}

	public User getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
}
