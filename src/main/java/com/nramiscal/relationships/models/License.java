package com.nramiscal.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=1, max=255)
	private String number;
	
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiration_date;
    
	@Column
	@Size(min=1, max=255)
	private String state;
	
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	// constructors
	
	public License() {

	}
	
	public License(String number, String state, Person person) {
		this.number = number;
		this.state = state;
		this.person = person;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	// createdAt, updatedAt
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	// getters

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public String getState() {
		return state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Person getPerson() {
		return person;
	}
	
	// setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setPerson(Person person) {
		this.person = person;
	}	

}
