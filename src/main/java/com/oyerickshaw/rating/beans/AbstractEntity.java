package com.oyerickshaw.rating.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@lombok.Data
@MappedSuperclass
public abstract class AbstractEntity<T> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	T id;
	
	@Column(name = "created_at", nullable = false)
    private Date createdAt;
	
	@Column(name = "updated_at", nullable = false)
    private Date updatedAt;
	
	@PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
